package org.sergiosoft.securityjwtbasedback.bussinessdomain.controllers;

import lombok.RequiredArgsConstructor;
import org.sergiosoft.securityjwtbasedback.bussinessdomain.constants.EndpointsConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class expose endpoints that any authenticated user with any role is able to consume.
 */
@RestController
@RequestMapping(EndpointsConstants.GUESTS_CONTROLLER_ENDPOINT)
@RequiredArgsConstructor
public class GuestController {

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage() {

        return "Welcome! This page is secured but it is not required to have a specific role, user is a guest.";
    }

    @GetMapping(value = "/bye")
    public String getByeMessage() {

        return "Bye guest!";
    }
}