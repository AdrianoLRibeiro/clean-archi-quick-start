package com.example.dto;

import com.example.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message = "name field can't be empty")
    private String name;

    @NotEmpty(message = "address field can't be empty")
    private String address;

    public static Set<UserDTO> fromEntity(Set<User> users) {
        return users
                .stream()
                .map(UserDTO::fromEntity)
                .collect(toSet());
    }

    public static UserDTO fromEntity(User user) {
        return builder()
                .name(user.getName())
                .address(user.getAddress())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .address(address)
                .build();
    }
}

