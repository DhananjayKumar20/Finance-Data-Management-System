package com.zorvyn.dhananjay.service.Service;

import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserRoleRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserStatusRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UserResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserResponseDTO getUserById(String emailFromRequest, Long id);
    UserResponseDTO updateUserRole(String emailFromRequest, Long id, UpdateUserRoleRequestDTO request);
    UserResponseDTO updateUserStatus(String emailFromRequest, Long id, UpdateUserStatusRequestDTO request);
    Page<UserResponseDTO> getAllUsers(String email, int zeroBasedPage, int size, String sortBy);
}
