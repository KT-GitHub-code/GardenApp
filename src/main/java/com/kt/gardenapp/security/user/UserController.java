package com.kt.gardenapp.security.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    public UserService userService;
    public UserDTOMapper userDTOMapper;

    public UserController(UserService userService, UserDTOMapper userDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping("/api/user/{username}")
    public Optional<UserDTO> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .stream()
                .map(userDTOMapper)
                .findFirst();
    }

}
