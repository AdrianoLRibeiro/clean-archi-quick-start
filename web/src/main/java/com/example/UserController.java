package com.example;

import com.example.dto.UserDTO;
import com.example.dto.UserListDTO;
import com.example.entities.User;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO examDTO) {
        return userService.save(examDTO.toEntity()) == null
                ? ResponseEntity.status(500).build()
                : ResponseEntity.status(201).build();
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<UserDTO> update(@Valid @RequestBody UserDTO userDTO) {
        User result = userService.update(userDTO.toEntity());
        return ResponseEntity.ok(UserDTO.fromEntity(result));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
        ResponseEntity.status(200).build();
    }

    @GetMapping
    public @ResponseBody ResponseEntity<UserListDTO> getAcriveUsers() {
        Set<User> users = userService.getActiveUsers();
        UserListDTO response = new UserListDTO(UserDTO.fromEntity(users));
        return ResponseEntity.ok(response);
    }
}
