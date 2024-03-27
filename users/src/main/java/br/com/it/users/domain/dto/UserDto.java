package br.com.it.users.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.it.users.domain.model.User;

public class UserDto {
    
    @JsonIgnore
    private Long id;
    private String name;
    private String email;
    
    public UserDto() {
    }
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
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

    public User toModel() {
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);

        return user;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
