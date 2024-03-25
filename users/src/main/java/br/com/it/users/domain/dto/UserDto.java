package br.com.it.users.domain.dto;

import br.com.it.users.domain.model.User;

public record UserDto(String name, String email) {
    
    public UserDto(User model) {
        this(
            model.getName(),
            model.getName()
        );
    }

    public User toModel() {
        User model = new User();
        model.setName(name);
        model.setEmail(email);
        return model;
    }
    
}
