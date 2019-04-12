package com.example.enums;

import com.example.entities.UserStatus;

public enum UserStatusDB {
    ACTIVE,
    INACTIVE;

    public static UserStatusDB fromEntity(UserStatus status) {
        return UserStatusDB.valueOf(status.toString());
    }
}
