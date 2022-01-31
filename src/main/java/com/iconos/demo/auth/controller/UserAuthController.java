package com.iconos.demo.auth.controller;

import com.iconos.demo.auth.dto.AuthenticationRequest;
import com.iconos.demo.auth.dto.AuthenticationResponse;
import com.iconos.demo.auth.dto.UserDto;
import com.iconos.demo.auth.service.JwtUtils;
import com.iconos.demo.auth.service.UserDetailsCustomService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    
    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    
    @Autowired
    public UserAuthController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    
    }
    
    
    @PostMapping("/sigup")
    public ResponseEntity<AuthenticationResponse> sigUp(@Valid @RequestBody UserDto user){
        this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    
    }
    
    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        
        UserDetails userDetails;
        
        try {
            Authentication auth = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
            
        } 
        catch (BadCredentialsException e) {
            throw  new Exception("Incorrect username o password",e);
        }
    
        final String jwt = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
    
}
