package com.web_4.StockNote.user.service;

import com.web_4.StockNote.user.dto.UserLoginRequestDto;
import com.web_4.StockNote.user.dto.UserRegisterRequestDto;
import com.web_4.StockNote.user.entity.User;
import com.web_4.StockNote.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HttpSession session;

    // 회원가입
    @Override
    public User registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        // 이메일 중복 확인
        if (userRepository.existsByuserEmail(userRegisterRequestDto.getUserEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // User 엔티티 저장
        User user = userRegisterRequestDto.toEntity();
        return  userRepository.save(user);
    }

    // 로그인
    @Override
    public User loginUser(UserLoginRequestDto userLoginRequestDto) {
        Optional<User> userOptional = userRepository.findByuserEmail(userLoginRequestDto.getUserEmail());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("이메일을 찾을 수 없습니다.");

        }
        User user = userOptional.get();
        if (!user.getUserPassword().equals(userLoginRequestDto.getUserPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("user", user);
        return user;
    }

    // 로그아웃
    @Override
    public void logoutUser() {
        session.invalidate(); // 세션 만료
    }
}
