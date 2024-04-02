package br.com.it.users.application.service;

import java.util.List;
import br.com.it.users.domain.dto.UserDto;

public interface IUserService {

    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    List<UserDto> findAll();

    void deleteById(Long id);
}
