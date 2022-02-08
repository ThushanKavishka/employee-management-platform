package com.expoundlabs.thushan.employeemanagementplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter @AllArgsConstructor @ToString
public class AuthenticationResponse implements Serializable {

    private final String jwt;

}
