package com.example.impl;

import com.example.entities.User;
import com.example.entity.UserDAO;
import com.example.enums.UserStatusDAO;
import com.example.repository.UserDataAccess;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDataAccessImpl implements UserDataAccess {

    private UserRepository userRepository;

    public UserDataAccessImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        UserDAO db = UserDAO.fromEntity(user);
        return userRepository.save(db).toEntity();
    }

    @Override
    public Set<User> getActiveUsers() {
        return userRepository.findByStatus(UserStatusDAO.ACTIVE)
                .stream()
                .map(UserDAO::toEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository
                .findById(Long.valueOf(id))
                .map(UserDAO::toEntity);
    }
}
