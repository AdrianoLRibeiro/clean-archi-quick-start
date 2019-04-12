package com.example.entities;

import org.junit.Before;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = User.builder().id("1").build();
    }
}
