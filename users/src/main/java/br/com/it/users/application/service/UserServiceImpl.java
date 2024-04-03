package br.com.it.users.application.service;

import br.com.it.users.domain.dto.UserDto;
import br.com.it.users.domain.exceptions.NotFoundException;
import br.com.it.users.domain.model.User;
import br.com.it.users.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto create(UserDto userDto) {
        User user = userRepository.save(userDto.toModel());
        return new UserDto(user);
    }

    public UserDto update(Long id, UserDto userDto) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User ID not found.");
        }
        User user = userDto.toModel();
        user.setId(id);
        userRepository.save(user);
        return new UserDto(user);
    }

    public List<UserDto> findAll() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        return new UserDto(user);
    }

    public void deleteById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User ID not found.");
        }
        userRepository.deleteById(id);
    }

}
