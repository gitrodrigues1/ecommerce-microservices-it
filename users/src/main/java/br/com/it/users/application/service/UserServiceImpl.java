package br.com.it.users.application.service;

import br.com.it.users.application.service.exception.BusinessException;
import br.com.it.users.application.service.exception.NotFoundException;
import br.com.it.users.domain.dto.CreateUserDto;
import br.com.it.users.domain.dto.GetUserDto;
import br.com.it.users.domain.dto.UserDto;
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

    public Optional<GetUserDto> create(CreateUserDto dto) {
        Optional.ofNullable(dto).orElseThrow(() -> new BusinessException("User must not be null"));
        Optional.ofNullable(dto.name()).orElseThrow(() -> new BusinessException("username must not be null"));
        Optional.ofNullable(dto.email()).orElseThrow(() -> new BusinessException("email must not be null"));
        Optional.ofNullable(dto.password()).orElseThrow(() -> new BusinessException("password must not be null"));
        var user = userRepository.save(dto.toModel());
        return Optional.of(new GetUserDto(user));
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
    public Optional<GetUserDto> findUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        var userDto = Optional.of(new GetUserDto(user));
        return userDto;
    }

}
