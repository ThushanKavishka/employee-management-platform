package com.expoundlabs.thushan.employeemanagementplatform.service;

import com.expoundlabs.thushan.employeemanagementplatform.model.UserData;
import com.expoundlabs.thushan.employeemanagementplatform.entity.User;
import com.expoundlabs.thushan.employeemanagementplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found " + username));
        return user.map(UserData::new).get();
    }
}
