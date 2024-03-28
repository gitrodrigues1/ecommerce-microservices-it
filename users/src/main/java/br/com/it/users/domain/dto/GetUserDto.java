package br.com.it.users.domain.dto;

import java.time.LocalDate;

import br.com.it.users.domain.model.User;

public record GetUserDto(
    Long id, 
    String name, 
    String email, 
    LocalDate createdAt) {
        
        public GetUserDto(User model) {
            this(model.getId(), model.getName(), model.getEmail(), model.getCreatedAt());
        }
}
