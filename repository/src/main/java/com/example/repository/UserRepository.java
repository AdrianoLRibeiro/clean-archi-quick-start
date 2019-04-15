package com.example.repository;

import com.example.entity.UserDAO;
import com.example.enums.UserStatusDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {

    List<UserDAO> findByStatus(UserStatusDAO status);
}
