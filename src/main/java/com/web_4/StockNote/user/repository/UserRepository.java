package com.web_4.StockNote.user.repository;

import com.web_4.StockNote.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일로 사용자 찾기
    Optional<User> findByuserEmail(String userEmail);

    // 사용자 이름으로 찾기
    Optional<User> findByuserName(String username);
}
