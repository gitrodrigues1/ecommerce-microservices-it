package br.com.it.users.domain.dto;

import br.com.it.users.domain.model.UserEnum;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.it.users.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    
    @JsonIgnore
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private UserEnum userEnum;

    @NotBlank
    private String senha;

    public UserDto() {
    }
    
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }
    public UserDto(String name, String email, LocalDate dataNascimento, String senha, UserEnum userEnum) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.userEnum = userEnum;
        this.dataNascimento = dataNascimento;
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

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public User toModel() {
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setSenha(this.senha);
        user.setDataNascimento(dataNascimento);
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
