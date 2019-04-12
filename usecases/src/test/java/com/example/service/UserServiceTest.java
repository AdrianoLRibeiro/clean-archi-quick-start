package com.example.service;

import com.example.entities.User;
import com.example.repository.UserDataAccess;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock private UserDataAccess userDataAccess;

    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userDataAccess);

        user = User.builder().name("user").build();

        when(userDataAccess.save(null)).thenThrow(RuntimeException.class);
        when(userDataAccess.save(user)).thenReturn(user);

        when(userDataAccess.findById("2")).thenReturn(empty());
        when(userDataAccess.findById("1")).thenReturn(of(user));
    }
}
