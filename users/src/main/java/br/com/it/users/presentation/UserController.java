package br.com.it.users.presentation;

import java.net.URI;
import java.util.List;
import br.com.it.users.application.service.IUserService;
import br.com.it.users.domain.dto.CreateUserDto;
import br.com.it.users.domain.dto.GetUserDto;
import br.com.it.users.domain.dto.UserDto;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<GetUserDto> createUser(@Valid @RequestBody CreateUserDto dto) {
        var createdUser = userService.create(dto).get();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.id())
            .toUri();
        return ResponseEntity.created(uri).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
        var userUpdated = userService.update(id, userDto);
        return ResponseEntity.ok().body(userUpdated);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        var users = userService.findAll();
        return ResponseEntity.ok().body((users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> findById(@PathVariable Long id) {
        var user = userService.findUserById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
        
    }
}
