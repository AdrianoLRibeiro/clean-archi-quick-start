package com.example.enums;

import com.example.entities.UserStatus;

public enum UserStatusDAO {
    ACTIVE,
    INACTIVE;

    public static UserStatusDAO fromEntity(UserStatus status) {
        return UserStatusDAO.valueOf(status.toString());
    }
}
