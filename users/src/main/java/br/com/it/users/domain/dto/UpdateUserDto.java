package br.com.it.users.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
    @NotNull Long id,
    String name,
    String email,
    String createdAt
) {


    
}
