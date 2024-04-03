package br.com.it.users.application.service;

import java.util.List;

import br.com.it.users.application.dto.UpdateUserDto;
import br.com.it.users.application.dto.UserDto;

public interface IUserService {

    UserDto create(UserDto userDto);

    UserDto update(Long id, UpdateUserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void deleteById(Long id);
}
