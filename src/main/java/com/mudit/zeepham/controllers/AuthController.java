package com.mudit.zeepham.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mudit.zeepham.config.JwtHelper;
import com.mudit.zeepham.dto.JwtRequest;
import com.mudit.zeepham.dto.JwtResponse;
import com.mudit.zeepham.entity.User;
import com.mudit.zeepham.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService service;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        System.out.println(request.getEmail());
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        System.out.println(token);
        JwtResponse response = new JwtResponse(token, userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody User user) {
        System.out.println(user);
        if (service.registerUser(user)) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            String token = this.helper.generateToken(userDetails);
            System.out.println(token);
            JwtResponse response = new JwtResponse(token, userDetails.getUsername());
            System.out.println(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        JwtResponse response = new JwtResponse(null, "Error occoured");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        
    }

    private JwtResponse JwtResponse(String token, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'JwtResponse'");
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    

}
