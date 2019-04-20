package com.example.entity;

import com.example.entities.User;
import com.example.enums.UserStatusDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import static java.lang.Long.valueOf;
import static org.springframework.util.StringUtils.isEmpty;

@Data
@Builder
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "usr_seq")
    private Long id;

    private String name;

    private String address;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatusDAO status = UserStatusDAO.ACTIVE;

    public User toEntity() {
        return User.builder()
                .id(id.toString())
                .name(name)
                .address(address)
                .build();
    }

    public static UserDAO fromEntity(User user) {
        return builder()
                .id(isEmpty(user.getId()) ? null : valueOf(user.getId()))
                .name(user.getName())
                .address(user.getAddress())
                .status(UserStatusDAO.fromEntity(user.getStatus()))
                .build();
    }
}

