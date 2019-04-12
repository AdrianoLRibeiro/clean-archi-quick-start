package com.example.repository;

import com.example.entity.UserDB;
import com.example.enums.UserStatusDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {

    List<UserDB> findByStatus(UserStatusDB status);
}
