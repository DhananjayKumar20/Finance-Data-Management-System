package com.zorvyn.dhananjay.service.Implementation;

import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserRoleRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserStatusRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UserResponseDTO;
import com.zorvyn.dhananjay.entity.User;
import com.zorvyn.dhananjay.entity.UserStatus;
import com.zorvyn.dhananjay.entity.UserType;
import com.zorvyn.dhananjay.exception.AccessDeniedException;
import com.zorvyn.dhananjay.exception.BadRequestException;
import com.zorvyn.dhananjay.exception.UserNotFoundException;
import com.zorvyn.dhananjay.repository.UserRepository;
import com.zorvyn.dhananjay.service.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

//<<------------------------------------Get All Users--------------------------------->>

    @Override
    public Page<UserResponseDTO> getAllUsers(String emailFromRequest, int page, int size, String sortBy) {

        User admin = getUserByEmail(emailFromRequest);

        if (admin.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Only admin can get All Users");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(this::mapToUserResponseDTO);
    }

//<<------------------------------------Get User By ID-------------------------------->>

    @Override
    public UserResponseDTO getUserById(String emailFromRequest, Long id) {

        User admin = getUserByEmail(emailFromRequest);
        if (admin.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Only admin can get User By Id");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        return mapToUserResponseDTO(user);
    }

//<<------------------------------------Update User Role------------------------------>>

    @Override
    public UserResponseDTO updateUserRole(String emailFromRequest, Long id, UpdateUserRoleRequestDTO request) {

        User admin = getUserByEmail(emailFromRequest);
        if (admin.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Only admin can update User Role");
        }

        if (request.getUserType() == null || request.getUserType().trim().isEmpty()) {
            throw new BadRequestException("User type cannot be null or empty");
        }

        UserType newRole;
        try {
            newRole = UserType.valueOf(request.getUserType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid user type: " + request.getUserType() + ". Allowed values: VIEWER, ANALYST, ADMIN");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setUserType(newRole);
        user.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepository.save(user);
        return mapToUserResponseDTO(updatedUser);
    }

//<<------------------------------------Update User Status---------------------------->>

    @Override
    public UserResponseDTO updateUserStatus(String emailFromRequest, Long id, UpdateUserStatusRequestDTO request) {

        User admin = getUserByEmail(emailFromRequest);
        if (admin.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Only admin can update User Status");
        }

        if (request.getStatus() == null || request.getStatus().trim().isEmpty()) {
            throw new BadRequestException("Status cannot be null or empty");
        }

        UserStatus newStatus;
        try {
            newStatus = UserStatus.valueOf(request.getStatus().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid status: " + request.getStatus() + ". Allowed values: ACTIVE, INACTIVE");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setUserStatus(newStatus);
        user.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepository.save(user);
        return mapToUserResponseDTO(updatedUser);
    }

   //<<----------------------------Response Helper Method--------------------->>

    private UserResponseDTO mapToUserResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .userType(user.getUserType())
                .status(user.getUserStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}