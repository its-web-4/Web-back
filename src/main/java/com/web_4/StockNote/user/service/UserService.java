package com.web_4.StockNote.user.service;

import com.web_4.StockNote.user.dto.UserLoginRequestDto;
import com.web_4.StockNote.user.dto.UserRegisterRequestDto;
import com.web_4.StockNote.user.entity.User;

public interface UserService {

    // 회원가입
    User registerUser(UserRegisterRequestDto userRegisterRequestDto);

    // 로그인
    User loginUser(UserLoginRequestDto userLoginRequestDto);

    // 로그아웃
    void logoutUser();
}
