package com.example.repository;

import com.example.entities.User;

import java.util.Optional;
import java.util.Set;

public interface UserDataAccess {

    User save(User user);

    Set<User> getActiveUsers();

    Optional<User> findById(String id);
}
