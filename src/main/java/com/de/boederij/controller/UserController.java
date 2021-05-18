package com.de.boederij.controller;

import com.de.boederij.config.exception.ResourceNotFoundException;
import com.de.boederij.model.User;
import com.de.boederij.repository.UserRepository;
import com.de.boederij.security.CurrentUser;
import com.de.boederij.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;






    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER')")
    public User getUserById(@PathVariable Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {

            return byId.get();
        }
        else {
             return User.builder().build();
        }
    }


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        System.out.println(userPrincipal);
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}