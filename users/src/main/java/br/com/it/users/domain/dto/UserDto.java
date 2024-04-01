package br.com.it.users.domain.dto;

import br.com.it.users.domain.model.UserEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.it.users.domain.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Locale;

public class UserDto {
    
    @JsonIgnore
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String dataNascimento;

    @NotNull
    private UserEnum userEnum;

    @NotNull
    private String senha;

    public UserDto() {
    }
    
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }
    public UserDto(String name, String email, String dataNascimento, String senha, UserEnum userEnum) {
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

    public String getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public User toModel() {
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setSenha(this.senha);

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
