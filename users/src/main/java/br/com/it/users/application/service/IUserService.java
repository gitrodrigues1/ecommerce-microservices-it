package br.com.it.users.application.service;

import java.util.List;
import br.com.it.users.domain.dto.UserDto;
import br.com.it.users.domain.model.User;

public interface IUserService {

    User create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    List<UserDto> findAll();

    UserDto findUserById(Long id);

    void deleteById(Long id);
}
