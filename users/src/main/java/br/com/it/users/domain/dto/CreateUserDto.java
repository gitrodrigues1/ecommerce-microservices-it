package br.com.it.users.domain.dto;

import java.time.LocalDate;

import br.com.it.users.domain.model.User;

public record CreateUserDto(
    String name,
    String email,
    String password
) {
    
    public User toModel(){
        var user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(LocalDate.now());
        return user;
    }

}
