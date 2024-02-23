package org.sergiosoft.securityjwtbasedback.bussinessdomain.services;

import org.springframework.stereotype.Service;
@Service
public class DemoService {

    public String getWelcomeMessage(){
        return "Hi, welcome! This is a secured endpoint.";
    }
}
