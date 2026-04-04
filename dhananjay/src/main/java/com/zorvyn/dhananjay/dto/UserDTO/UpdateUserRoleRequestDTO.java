package com.zorvyn.dhananjay.dto.UserDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRoleRequestDTO {

    private String userType;   // "VIEWER" | "ANALYST" | "ADMIN"
}