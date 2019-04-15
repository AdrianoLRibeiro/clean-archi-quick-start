package com.example.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

@Builder
@Data
@EqualsAndHashCode(of="id")
public class User {

    private String id;

    private String name;

    private String adress;

    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    public boolean hasId() {
        return !hasNotId();
    }

    public boolean hasNotId() {
        return StringUtils.isEmpty(id);
    }

    public User setToInactive() {
        status = UserStatus.INACTIVE;
        return this;
    }

    private boolean isInactive() {
        return UserStatus.INACTIVE.equals(status);
    }
}
