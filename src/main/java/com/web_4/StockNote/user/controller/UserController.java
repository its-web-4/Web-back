package com.web_4.StockNote.user.controller;

import com.web_4.StockNote.user.dto.UserLoginRequestDto;
import com.web_4.StockNote.user.dto.UserRegisterRequestDto;
import com.web_4.StockNote.user.entity.User;
import com.web_4.StockNote.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // 회원가입 API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        userService.registerUser(userRegisterRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        User user = userService.loginUser(userLoginRequestDto);
        session.setAttribute("user", user);
        return ResponseEntity.ok("로그인 성공");
    }

    // 로그아웃 API
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // 세션 만료
        return ResponseEntity.ok("로그아웃 성공");
    }
}

