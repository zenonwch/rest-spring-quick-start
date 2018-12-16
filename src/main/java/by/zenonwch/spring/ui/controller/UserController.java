package by.zenonwch.spring.ui.controller;

import by.zenonwch.spring.service.UserService;
import by.zenonwch.spring.ui.dto.UserRegistrationDto;
import by.zenonwch.spring.ui.dto.UserResponseDto;
import by.zenonwch.spring.ui.dto.UserUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getUsers(
            @RequestParam(value = "page", defaultValue = "1") final int page,
            @RequestParam(value = "limit", defaultValue = "50") final int limit) {
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}", produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDto> getUser(@PathVariable final String userId) {
        final UserResponseDto user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE},
            produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody final UserRegistrationDto user) {
        final UserResponseDto createdUser = userService.createUser(user);

        return ResponseEntity.ok(createdUser);
    }

    @PutMapping(path = "{userId}", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE},
            produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("userId") final String userId, @Valid @RequestBody final UserUpdateDto user) {
        final UserResponseDto updatedUser = userService.updateUserInfo(userId, user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") final String userId) {
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
