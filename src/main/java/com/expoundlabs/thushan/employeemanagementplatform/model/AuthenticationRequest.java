package com.expoundlabs.thushan.employeemanagementplatform.model;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

}
