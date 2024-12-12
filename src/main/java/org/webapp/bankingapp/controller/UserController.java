package org.webapp.bankingapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.webapp.bankingapp.converter.Converter;
import org.webapp.bankingapp.dto.UserCreateDto;
import org.webapp.bankingapp.dto.UserResponseDto;
import org.webapp.bankingapp.entity.User;
import org.webapp.bankingapp.security.AuthenticationService;
import org.webapp.bankingapp.security.model.JwtAuthenticationResponse;
import org.webapp.bankingapp.security.model.SignInRequest;
import org.webapp.bankingapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<User, UserCreateDto, UserResponseDto> createConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<User> getAll() {

        return userService.getAll();
    }

    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserCreateDto userDto) {
        User user = createConverter.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDatabase = userService.create(user);
        UserResponseDto dto = createConverter.toDto(userFromDatabase);
        return dto;
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInRequest request) {
        return authenticationService.authenticate(request);
    }


    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/search")
    public User getByName(@RequestParam("name") String name) {
        return userService.getByName(name);
    }

    @PostMapping("/equals_passwords")
    public List<User> getWithEqualsPassword(@RequestBody String password) {
        return userService.getWithEqualsPasswords(password);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
