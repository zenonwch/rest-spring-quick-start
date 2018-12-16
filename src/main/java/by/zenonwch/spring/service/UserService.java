package by.zenonwch.spring.service;

import by.zenonwch.spring.ui.dto.UserRegistrationDto;
import by.zenonwch.spring.ui.dto.UserResponseDto;
import by.zenonwch.spring.ui.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRegistrationDto user);

    UserResponseDto getUser(String userId);

    List<UserResponseDto> getUsers();

    UserResponseDto updateUserInfo(String userId, UserUpdateDto userInfo);

    void deleteUser(String userId);
}
