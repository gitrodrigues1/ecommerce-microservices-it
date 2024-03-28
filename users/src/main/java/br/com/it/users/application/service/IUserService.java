package br.com.it.users.application.service;

import java.util.List;
import java.util.Optional;

import br.com.it.users.domain.dto.CreateUserDto;
import br.com.it.users.domain.dto.GetUserDto;
import br.com.it.users.domain.dto.UserDto;

public interface IUserService {

    Optional<GetUserDto> create(CreateUserDto userDto);

    UserDto update(Long id, UserDto userDto);

    List<UserDto> findAll();

    Optional<GetUserDto> findUserById(Long id);

    void deleteById(Long id);
}
