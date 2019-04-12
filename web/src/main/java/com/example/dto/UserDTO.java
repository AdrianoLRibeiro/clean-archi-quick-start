package com.example.dto;

import com.example.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String adress;

    public static Set<UserDTO> fromEntity(Set<User> users) {
        return users
                .stream()
                .map(UserDTO::fromEntity)
                .collect(toSet());
    }

    public static UserDTO fromEntity(User user) {
        return builder()
                .name(user.getName())
                .adress(user.getAdress())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .adress(adress)
                .build();
    }
}

