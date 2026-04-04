package com.zorvyn.dhananjay.service.Implementation;

import com.zorvyn.dhananjay.config.JwtUtils;
import com.zorvyn.dhananjay.dto.AuthDTO.AuthResponseDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.LoginRequestDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.SignupRequestDTO;
import com.zorvyn.dhananjay.entity.User;
import com.zorvyn.dhananjay.entity.UserStatus;
import com.zorvyn.dhananjay.entity.UserType;
import com.zorvyn.dhananjay.exception.AuthenticationException;
import com.zorvyn.dhananjay.repository.UserRepository;
import com.zorvyn.dhananjay.service.Service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

//<<------------------------------------Signup---------------------------------------->>

    @Override
    public AuthResponseDTO signup(SignupRequestDTO request) {

        // Validate mandatory fields
        if (request == null) {
            throw new AuthenticationException("Request body cannot be null");
        }
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new AuthenticationException("Email cannot be null or empty");
        }
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new AuthenticationException("Name cannot be null or empty");
        }
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new AuthenticationException("Password cannot be null or empty");
        }
        if (request.getUserType() == null || request.getUserType().trim().isEmpty()) {
            throw new AuthenticationException("User type is required");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new AuthenticationException("User already exists with email: " + request.getEmail());
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserType(UserType.valueOf(request.getUserType()));
        user.setUserStatus(UserStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        String token = jwtUtils.generateToken(savedUser.getEmail());

        AuthResponseDTO response = new AuthResponseDTO();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setToken(token);
        response.setMessage("Signup successful");
        return response;
    }

//<<------------------------------------Login---------------------------------------->>

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid  password");
        }

        String token = jwtUtils.generateToken(user.getEmail());

        AuthResponseDTO response = new AuthResponseDTO();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setToken(token);
        response.setMessage("Login successful");
        return response;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("User not found"));
    }
}
