package com.zorvyn.dhananjay.controller.UserManagement;

import com.zorvyn.dhananjay.Pagination.PaginatedResponse;
import com.zorvyn.dhananjay.config.JwtUtils;
import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserRoleRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UpdateUserStatusRequestDTO;
import com.zorvyn.dhananjay.dto.UserDTO.UserResponseDTO;
import com.zorvyn.dhananjay.service.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    private String getEmailFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("JWT token missing");
        }
        String token = authHeader.substring(7);
        return jwtUtils.getEmailFromJwt(token);
    }

//<<------------------------------------Get All Users--------------------------------->>

    @GetMapping
    public ResponseEntity<PaginatedResponse<UserResponseDTO>> getAllUsers(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        String email = getEmailFromRequest(request);

        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<UserResponseDTO> response = userService.getAllUsers(
                email,
                zeroBasedPage,
                size,
                sortBy
        );

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }

//<<------------------------------------Get User By ID-------------------------------->>

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(HttpServletRequest request,
            @PathVariable Long id) {

        String email = getEmailFromRequest(request);
        UserResponseDTO response = userService.getUserById(email, id);
        return ResponseEntity.ok(response);
    }

//<<------------------------------------Update User Role------------------------------>>

    @PatchMapping("/{id}/role")
    public ResponseEntity<UserResponseDTO> updateUserRole(HttpServletRequest request,
            @PathVariable Long id,
            @RequestBody UpdateUserRoleRequestDTO requestBody) {

        String email = getEmailFromRequest(request);
        UserResponseDTO response = userService.updateUserRole(email, id, requestBody);
        return ResponseEntity.ok(response);
    }

//<<------------------------------------Update User Status---------------------------->>

    @PatchMapping("/{id}/status")
    public ResponseEntity<UserResponseDTO> updateUserStatus(HttpServletRequest request,
            @PathVariable Long id,
            @RequestBody UpdateUserStatusRequestDTO requestBody) {

        String email = getEmailFromRequest(request);
        UserResponseDTO response = userService.updateUserStatus(email, id, requestBody);
        return ResponseEntity.ok(response);
    }
}