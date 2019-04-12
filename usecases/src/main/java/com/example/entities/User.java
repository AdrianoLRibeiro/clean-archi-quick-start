package com.example.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Builder
@ToString
@EqualsAndHashCode(of="id")
public class User {

    @Getter private String id;

    @Getter @Setter private String name;

    @Getter @Setter private String adress;

    @Builder.Default
    @Getter private UserStatus status = UserStatus.ACTIVE;

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
