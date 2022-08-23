package com.blog.hw3.security;

import com.blog.hw3.entity.Users;
import com.blog.hw3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("닉네임을 찾을 수 없습니다."+username));
        // return new UserDetailImp(user);
        Users user = userRepository.findByUsername(username).orElseThrow( ()-> new UsernameNotFoundException("닉네임을 찾을 수 없습니다."+username));

        return new UserDetailImp(user);
    }
}
