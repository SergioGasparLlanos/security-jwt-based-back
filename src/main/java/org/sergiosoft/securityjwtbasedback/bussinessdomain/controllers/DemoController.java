package org.sergiosoft.securityjwtbasedback.bussinessdomain.controllers;

import org.sergiosoft.securityjwtbasedback.bussinessdomain.services.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping(value = "demo")
    public String getWelcomeMessage() {
        return demoService.getWelcomeMessage();
    }
}