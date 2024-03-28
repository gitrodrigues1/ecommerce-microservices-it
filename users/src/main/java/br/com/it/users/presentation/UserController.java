package br.com.it.users.presentation;

import java.util.List;
import br.com.it.users.application.service.IUserService;
import br.com.it.users.domain.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        var createdUser = userService.create(userDto);
        return ResponseEntity.ok().body(new UserDto(createdUser));
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

}
