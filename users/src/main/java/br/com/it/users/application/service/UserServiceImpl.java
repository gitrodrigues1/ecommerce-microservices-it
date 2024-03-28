package br.com.it.users.application.service;

import br.com.it.users.domain.dto.UserDto;
import br.com.it.users.domain.model.User;
import br.com.it.users.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDto userDto) {
        return userRepository.save(userDto.toModel());
    }

    public UserDto update(Long id, UserDto userDto) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User ID not found.");
        }
        var user = userDto.toModel();
        user.setId(id);
        userRepository.save(user);
        return new UserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        var users =  userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    @Override
    public void deleteById(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User ID not found.");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        var userDto = new UserDto(user);
        return userDto;
    }

}
