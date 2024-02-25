package org.sergiosoft.securityjwtbasedback.bussinessdomain.controllers;

import lombok.RequiredArgsConstructor;
import org.sergiosoft.securityjwtbasedback.authentication.constants.RoleConstants;
import org.sergiosoft.securityjwtbasedback.bussinessdomain.constants.EndpointsConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class expose endpoints that any authenticated user with admin role is able to consume.
 */
@RestController
@RequestMapping(EndpointsConstants.ADMINS_CONTROLLER_ENDPOINT)
@RequiredArgsConstructor
@PreAuthorize(RoleConstants.ADMIN_ROLE_PREAUTHORIZE)
public class AdminController {

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage() {

        return "Welcome! This page is secured and it is required to have an admin role";
    }

    @GetMapping(value = "/bye")
    public String getByeMessage() {

        return "Bye admin!";
    }
}
