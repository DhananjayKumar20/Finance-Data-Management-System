package com.zorvyn.dhananjay.dto.UserDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserStatusRequestDTO {

    private String status;    // "ACTIVE" | "INACTIVE"
}