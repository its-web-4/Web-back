package com.web_4.StockNote.user.dto;

import com.web_4.StockNote.user.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegisterRequestDto {
    private String userEmail;
    private String userName;
    private String userPassword;

    // entity로 변환
    public User toEntity() {
        return User.builder()
                .userEmail(this.userEmail)
                .userName(this.userName)
                .userPassword(this.userPassword)  // 비밀번호는 암호화 필수
                .role(User.Role.USER)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
