package org.sergiosoft.securityjwtbasedback.authentication.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.AuthResponseDTO;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.LoginRequestDTO;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.RegisterRequestDTO;
import org.sergiosoft.securityjwtbasedback.authentication.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterRequestDTO request) {

        return ResponseEntity.ok(authService.register(request));
    }
}