package com.web_4.StockNote.user.service;

import com.web_4.StockNote.user.dto.UserLoginRequestDto;
import com.web_4.StockNote.user.dto.UserRegisterRequestDto;
import com.web_4.StockNote.user.entity.User;
import com.web_4.StockNote.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        if (userRepository.findByuserEmail(userRegisterRequestDto.getUserEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");
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
            throw new UserNotFoundException("이메일을 찾을 수 없습니다."); // 404

        }
        User user = userOptional.get();
        if (!user.getUserPassword().equals(userLoginRequestDto.getUserPassword())) {
            throw new UserNotFoundException("비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("user", user);
        return user;
    }

    // 로그아웃
    @Override
    public void logoutUser() {
        session.invalidate(); // 세션 만료
    }

    // 409 Conflict
    @ResponseStatus(HttpStatus.CONFLICT)
    public class EmailAlreadyExistsException extends RuntimeException {
        public EmailAlreadyExistsException(String message) {
            super(message);
        }
    }

    // 404 Not Found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
