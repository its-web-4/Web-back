package com.web_4.StockNote.user.dto;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String userEmail;
    private String userPassword;
}
