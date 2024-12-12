package org.webapp.bankingapp.converter;

import org.springframework.stereotype.Component;
import org.webapp.bankingapp.dto.UserCreateDto;
import org.webapp.bankingapp.dto.UserResponseDto;
import org.webapp.bankingapp.entity.User;

@Component
public class UserCreateConverter implements Converter<User, UserCreateDto, UserResponseDto>{

    @Override
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getLogin(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return new User(userCreateDto.getLogin(), userCreateDto.getPassword(), userCreateDto.getEmail());
    }
}
