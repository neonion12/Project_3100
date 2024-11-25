package com.ProductStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "series", nullable = false)
    private int series;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "roll", nullable = false)
    private int roll;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "confirm_password", nullable = false)
    private String confirmPassword;

    @Column(name = "gender", nullable = false)
    private String gender;

    // Default constructor
    public UserEntity() {
    }

    // Parameterized constructor
    public UserEntity(String nickname, int series, String department, int roll, String email, String password, String confirmPassword, String gender) {
        this.nickname = nickname;
        this.series = series;
        this.department = department;
        this.roll = roll;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", nickname=" + nickname + ", series=" + series + ", department=" + department
                + ", roll=" + roll + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
                + ", gender=" + gender + "]";
    }
}
