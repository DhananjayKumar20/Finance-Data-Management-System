package com.zorvyn.dhananjay.dto.AuthDTO;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String email;
    private String name;
    private String password;
    private String userType; // ADMIN / APPLICANT
//    private String profileHeadline;
//    private String address;
}