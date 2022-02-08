package com.expoundlabs.thushan.employeemanagementplatform.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Employee implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    @Builder
    @JsonCreator
    public Employee(Long id, String name, String email, String jobTitle, String phone, String employeeCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.employeeCode = employeeCode;
    }

}
