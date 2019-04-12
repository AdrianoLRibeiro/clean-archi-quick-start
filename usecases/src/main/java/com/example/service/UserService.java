package com.example.service;

import com.example.entities.User;
import com.example.repository.UserDataAccess;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

@Service
public class UserService {

    private UserDataAccess userDataAccess;

    public UserService(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    public User save(User user) {
        if (user == null) throw new IllegalArgumentException("Can't save null user");

        return userDataAccess.save(user);
    }

    public Set<User> getActiveUsers() {
        return userDataAccess.getActiveUsers();
    }

    public User update(User user) {
        if (user == null) throw new IllegalArgumentException("Can't update null user");

        User found = userDataAccess
                .findById(user.getId())
                .orElseThrow(() -> new RuntimeException("user not found with id: " + user.getId()));

        found.setAdress(user.getAdress());
        found.setName(user.getName());

        return userDataAccess.save(found);
    }

    public User delete(String id) {
        if (StringUtils.isEmpty(id)) throw new IllegalArgumentException("Can't inactive null userId");

        User found = userDataAccess.
                findById(id)
                .orElseThrow(() -> new RuntimeException("user not found with id: " + id));

        return userDataAccess.save(found.setToInactive());
    }
}
