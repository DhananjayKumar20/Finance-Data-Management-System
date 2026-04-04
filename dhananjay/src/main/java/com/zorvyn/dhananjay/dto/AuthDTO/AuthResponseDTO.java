package com.zorvyn.dhananjay.dto.AuthDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String email;
    private String name;
    private String token;
    private String message;

    // extra constructor (without token)
    public AuthResponseDTO(String email, String name, String message) {
        this.email = email;
        this.name = name;
        this.message = message;
    }
}