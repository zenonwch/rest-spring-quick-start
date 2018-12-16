package by.zenonwch.spring.service.impl;

import by.zenonwch.spring.exception.UserNotFoundException;
import by.zenonwch.spring.service.UserService;
import by.zenonwch.spring.ui.dto.UserRegistrationDto;
import by.zenonwch.spring.ui.dto.UserResponseDto;
import by.zenonwch.spring.ui.dto.UserUpdateDto;
import by.zenonwch.spring.util.Utils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final Map<String, UserResponseDto> users = new HashMap<>();

    private final Utils utils;

    public UserServiceImpl(final Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserResponseDto createUser(final UserRegistrationDto user) {
        final String userId = utils.generateUserId();

        final UserResponseDto createdUser = new UserResponseDto();
        createdUser.setUserId(userId);
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
        createdUser.setEmail(user.getEmail());

        users.put(userId, createdUser);

        return users.get(userId);
    }

    @Override
    public UserResponseDto getUser(final String userId) {
        final UserResponseDto user = users.get(userId);

        if (user == null) {
            throw new UserNotFoundException("User with id = '" + userId + "' not found.");
        }

        return user;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        final Collection<UserResponseDto> values = users.values();

        return new ArrayList<>(values);
    }

    @Override
    public UserResponseDto updateUserInfo(final String userId, final UserUpdateDto userInfo) {
        final UserResponseDto existedUser = users.get(userId);

        if (existedUser == null) {
            throw new UserNotFoundException("User with id = '" + userId + "' not found.");
        }

        existedUser.setFirstName(userInfo.getFirstName());
        existedUser.setLastName(userInfo.getLastName());

        return users.get(userId);
    }

    @Override
    public void deleteUser(final String userId) {
        users.remove(userId);
    }
}
