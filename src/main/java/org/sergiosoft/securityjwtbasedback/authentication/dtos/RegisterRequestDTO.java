package org.sergiosoft.securityjwtbasedback.authentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String country;
}