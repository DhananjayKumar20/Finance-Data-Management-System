package com.zorvyn.dhananjay.service.Service;

import com.zorvyn.dhananjay.dto.AuthDTO.AuthResponseDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.LoginRequestDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.SignupRequestDTO;
import com.zorvyn.dhananjay.entity.User;

public interface AuthService {

    AuthResponseDTO signup(SignupRequestDTO request);
    AuthResponseDTO login(LoginRequestDTO request);
    User findByEmail(String email);
}
