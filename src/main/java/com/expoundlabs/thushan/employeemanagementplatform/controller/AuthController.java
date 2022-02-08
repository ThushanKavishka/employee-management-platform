package com.expoundlabs.thushan.employeemanagementplatform.controller;

import com.expoundlabs.thushan.employeemanagementplatform.model.AuthenticationRequest;
import com.expoundlabs.thushan.employeemanagementplatform.model.AuthenticationResponse;
import com.expoundlabs.thushan.employeemanagementplatform.service.CustomUserDetailsService;
import com.expoundlabs.thushan.employeemanagementplatform.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/v1", produces = "application/json", consumes = "application/json")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> generateAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.ACCEPTED);
    }

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        String str = "Welcome Home";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdminDetails() {
        String str = "Welcome Admin";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/developer")
    public ResponseEntity<String> getDeveloperDetails() {
        String str = "Welcome Developer";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

}
