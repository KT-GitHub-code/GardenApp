package com.kt.gardenapp.controller;

import com.kt.gardenapp.model.DTOs.AuthResponseDTO;
import com.kt.gardenapp.model.DTOs.LoginDTO;
import com.kt.gardenapp.model.DTOs.RegisterDTO;
import com.kt.gardenapp.model.Role;
import com.kt.gardenapp.model.User;
import com.kt.gardenapp.repository.RoleRepository;
import com.kt.gardenapp.repository.UserRepository;
import com.kt.gardenapp.security.config.JWTGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private JWTGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.username(),
                        loginDTO.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        System.out.println("register route");
        if (userRepository.existsByUsername(registerDTO.username())){
            return new ResponseEntity<>("Username " + registerDTO.username()+" is taken", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDTO.username());
        user.setPassword(passwordEncoder.encode(registerDTO.password()));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);
        System.out.println(user +" in the register route.");
        return new ResponseEntity<>(user.getUsername() + " registered.", HttpStatus.OK);
    }
}
