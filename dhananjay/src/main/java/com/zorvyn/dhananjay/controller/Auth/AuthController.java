package com.zorvyn.dhananjay.controller.Auth;

import com.zorvyn.dhananjay.dto.AuthDTO.AuthResponseDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.LoginRequestDTO;
import com.zorvyn.dhananjay.dto.AuthDTO.SignupRequestDTO;
import com.zorvyn.dhananjay.service.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService userService;

    public AuthController(AuthService userService)
    {
        this.userService = userService;
    }

//<<------------------------------------Signup---------------------------------------->>

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> signup(@RequestBody SignupRequestDTO request) {
        return ResponseEntity.ok(userService.signup(request));
    }

//<<------------------------------------Login----------------------------------------->>

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(userService.login(request));
    }

}


