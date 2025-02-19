package com.web_4.StockNote.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName; // 이름

    @Column(unique = true, nullable = false)
    private String userEmail; // 이메일

    @Column(nullable = false)
    private String userPassword; // 비밀번호

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // private List<Watchlist> watchlistList = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now(); // 생성 시간

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER; // 사용자 역할

    public enum Role {
        USER, ADMIN
    }
}
