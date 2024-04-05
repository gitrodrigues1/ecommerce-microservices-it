package br.com.it.users.application.dto;

import br.com.it.users.domain.model.User;
import br.com.it.users.domain.model.UserEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;


public class UpdateUserDto {

    @JsonIgnore
    private Long id;

    @Column(nullable = true)
    private String name;

    @Email
    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private LocalDate birthDate;
    
    private UserEnum userEnum;

    private String password;

    public UpdateUserDto() {
    }

    public UpdateUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
    public UpdateUserDto(String name, String email, LocalDate dataNascimento, String senha, UserEnum userEnum) {
        this.name = name;
        this.email = email;
        this.password = senha;
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

    public void setPassword(String senha) { this.password = senha; }

    public User toModel() {
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setBirthDate(birthDate);
        user.setUserEnum(userEnum);

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
