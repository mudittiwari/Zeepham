package com.mudit.zeepham.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mudit.zeepham.entity.Authority;
import com.mudit.zeepham.entity.User;
import com.mudit.zeepham.repository.UserRepo;

@Service
public class UserService {
    

    @Autowired
    private UserRepo repo;
        @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean registerUser(User user){
        user.setEnabled(true);
        Authority authority=new Authority();
        authority.setUsername(user.getUsername());
        authority.setAuthority("ROLE_USER");
        user.setAuthority(authority);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       
        return repo.registerUser(user);
    }
}
