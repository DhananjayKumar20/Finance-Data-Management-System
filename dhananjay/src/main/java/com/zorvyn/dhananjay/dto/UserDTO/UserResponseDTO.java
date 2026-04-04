package com.zorvyn.dhananjay.dto.UserDTO;

import com.zorvyn.dhananjay.entity.UserStatus;
import com.zorvyn.dhananjay.entity.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private UserType userType;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public UserType getUserType() { return userType; }
//    public void setUserType(UserType userType) { this.userType = userType; }
//
//    public Status getStatus() { return status; }
//    public void setStatus(Status status) { this.status = status; }
//
//    public Instant getCreatedAt() { return createdAt; }
//    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
//
//    public Instant getUpdatedAt() { return updatedAt; }
//    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
//

}


