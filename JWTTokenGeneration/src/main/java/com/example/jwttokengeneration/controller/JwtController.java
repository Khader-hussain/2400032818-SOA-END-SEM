
package com.example.jwttokengeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jwttokengeneration.model.UserRequest;
import com.example.jwttokengeneration.service.JwtService;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/generate")
    public String generateToken(@RequestBody UserRequest user) {

        return jwtService.generateToken(
                user.getUsername(),
                user.getRole()
        );
    }
}
