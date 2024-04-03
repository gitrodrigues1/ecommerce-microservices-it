package br.com.it.users.application.dto;

import br.com.it.users.domain.model.UserEnum;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.it.users.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private UserEnum userEnum;

    @JsonIgnore
    private String password;

    public UserDto() {
    }
    
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.userEnum = user.getUserEnum();
    }
    public UserDto(String name, String email, LocalDate dataNascimento, String password, UserEnum userEnum) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userEnum = userEnum;
        this.birthDate = dataNascimento;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate dataNascimento) { this.birthDate = dataNascimento; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User toModel() {
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setBirthDate(this.birthDate);
        user.setUserEnum(this.userEnum);

        return user;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public UserEnum getUserEnum() {
        return userEnum;
    }

    public void setUserEnum(UserEnum userEnum) {
        this.userEnum = userEnum;
    }
}
