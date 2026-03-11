package com.amigoscode.user;

import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 05 - Add @Service annotation to this class
//  Inject UserRepository via constructor injection
//  Use the injected repository in getAllUsers()
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<String> getAllUsers() {
        return userRepository.findAllUsers(); // Replace with userRepository.findAllUsers()
    }

}
