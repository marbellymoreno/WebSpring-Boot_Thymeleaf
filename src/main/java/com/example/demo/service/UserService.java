package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    public List<User> obtenerUsuarios() {
        return Arrays.asList(
            new User("Ana", "García", "ana@gmail.com"),
            new User("Luis", "Martínez", null),
            new User("Sofía", "Ramírez", "sofia@gmail.com")
        );
    }
}
