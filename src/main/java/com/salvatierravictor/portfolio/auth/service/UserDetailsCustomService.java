package com.salvatierravictor.portfolio.auth.service;

import com.salvatierravictor.portfolio.auth.dto.UserDTO;
import com.salvatierravictor.portfolio.auth.entity.UserEntity;
import com.salvatierravictor.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    //private EmailService emailService;

    public UserDetailsCustomService(@Autowired @Lazy PasswordEncoder passwordEncoder, @Autowired @Lazy UserRepository userRepository ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        //this.emailService = emailService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var foundUser = userRepository.findByUsername(username);
        Collection<GrantedAuthority> authorities = foundUser.getRoles().stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                .collect(Collectors.toList());
        return new User(
                foundUser.getUsername(),
                foundUser.getPassword(),
                authorities
        );
    }


    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity = this.userRepository.save(userEntity);
        if (userEntity != null){
            //emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }

}