package br.com.it.users.application.service;

import br.com.it.users.domain.dto.UserDto;
import br.com.it.users.domain.model.User;
import br.com.it.users.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User  create(UserDto userDto) {
        return userRepository.save(userDto.toModel());
    }

    public UserDto findById(Long id) {
        var user = userRepository.findById(id).get();
        return new UserDto(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }
}
