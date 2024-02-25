package org.sergiosoft.securityjwtbasedback.authentication.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sergiosoft.securityjwtbasedback.authentication.constants.RoleConstants;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.AuthResponseDTO;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.LoginRequestDTO;
import org.sergiosoft.securityjwtbasedback.authentication.dtos.RegisterRequestDTO;
import org.sergiosoft.securityjwtbasedback.authentication.entities.UserEntity;
import org.sergiosoft.securityjwtbasedback.authentication.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginRequestDTO request) {
        log.info("Started request to login. request = {}", request);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        log.info("User found by username. user = {}", user);

        String token = jwtService.getToken(user);

        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }

    public AuthResponseDTO register(RegisterRequestDTO request) {
        log.info("Started request to register a user. request = {}", request);

        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(RoleConstants.ADMIN_ROLE)//this should be dynamic
                .build();

        log.info("Entity ready to save. userEntity = {}", userEntity);

        userRepository.save(userEntity);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(userEntity))
                .build();

    }
}
