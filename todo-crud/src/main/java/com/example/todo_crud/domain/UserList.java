package com.example.todo_crud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class UserList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 자동 증가 ID

    @Column(nullable = false, length = 20)
    private String userId;  // 사용자 계정 ID

    @Column(nullable = false, length = 20)
    private String password;  // 사용자 계정 비밀번호


    @Column(nullable = false, length = 100)
    private String name;  // 사용자 이름

    @Column(nullable = false, unique = true, length = 100)
    private String email;  // 이메일 (고유)

    @Column(nullable = false, unique = true, length = 15)
    private String phone;  // 전화번호 (고유)

    @Column(name = "registration_date")
    private LocalDate registrationDate;  // 가입 날짜

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private UserType userType;  // 사용자 유형 (ENUM)

    @Column(name = "profile_image_id", nullable = false)
    private int profileImageId;  // 프로필 사진 ID

    @Column(columnDefinition = "TEXT")
    private String experience;  // 강사 경력 정보 (optional)

    public enum UserType {
        ADMIN,
        USER,
        STUDENT // 정의가 되어 있어야 합니다.
    }

    public UserList() {
    }

    public UserList(Long id, String userId, String password, String name, String email, String phone, LocalDate registrationDate, UserType userType, int profileImageId, String experience) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.userType = userType;
        this.profileImageId = profileImageId;
        this.experience = experience;
    }
}
