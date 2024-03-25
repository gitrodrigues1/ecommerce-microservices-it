package br.com.it.users.presentation;

import br.com.it.users.application.service.IUserService;
import br.com.it.users.domain.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    //
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        var createdUser = userService.create(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(location).body(new UserDto(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        var users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    // oi
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
        var userUpdated = userService.update(id, userDto);
        return ResponseEntity.ok().body(userUpdated);
    }
}
