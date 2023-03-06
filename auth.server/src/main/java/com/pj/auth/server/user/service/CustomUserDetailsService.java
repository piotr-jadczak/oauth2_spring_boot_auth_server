package com.pj.auth.server.user.service;

import com.pj.auth.server.user.repository.UserReadOnlyRepository;
import com.pj.auth.server.user.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.pj.auth.server.user.validation.UserResult.USER_WITH_USERNAME_NOT_EXISTS;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserReadOnlyRepository userRepository;

    CustomUserDetailsService(UserReadOnlyRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(USER_WITH_USERNAME_NOT_EXISTS.getMessage(username)));
    }
}
