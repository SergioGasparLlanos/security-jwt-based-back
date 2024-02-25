package org.sergiosoft.securityjwtbasedback.bussinessdomain.controllers;

import lombok.RequiredArgsConstructor;
import org.sergiosoft.securityjwtbasedback.authentication.constants.RoleConstants;
import org.sergiosoft.securityjwtbasedback.bussinessdomain.constants.EndpointsConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class expose endpoints that any authenticated user with user role is able to consume.
 */
@RestController
@RequestMapping(EndpointsConstants.USERS_CONTROLLER_ENDPOINT)
@PreAuthorize(RoleConstants.USER_ROLE_PREAUTHORIZE)
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage() {
        
        return "Welcome! This page is secured and it is required to have a user role";
    }

    @GetMapping(value = "/bye")
    public String getByeMessage() {

        return "Bye user!";
    }
}
