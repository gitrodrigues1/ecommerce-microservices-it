package br.com.it.users.application.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.it.users.domain.model.User;
import br.com.it.users.domain.model.UserEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class CreateUserDto {
    
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @DateTimeFormat(style = "YYYY-mm-dd")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private UserEnum userEnum;

    public CreateUserDto() {
    }

    public CreateUserDto(@NotBlank String name, @NotBlank String email, LocalDate birthDate, UserEnum userEnum) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.userEnum = userEnum;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UserEnum getUserEnum() {
        return userEnum;
    }

    public void setUserEnum(UserEnum userEnum) {
        this.userEnum = userEnum;
    }

    public User toModel() {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setUserEnum(userEnum);

        return user;
    }
}
