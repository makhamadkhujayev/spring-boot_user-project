package com.example.user_project.service;

import com.example.user_project.entity.User;
import com.example.user_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        Optional<User> optionalEmail = userRepository.findByEmail(user.getEmail());
        if (optionalEmail.isPresent()) {
            throw new IllegalStateException("User with this email: " + user.getEmail() + " already exists");
        }else{
            userRepository.save(user);
        }
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with provided " + userId + " does not exists"));
        if (name != null && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }
        if (email != null && !Objects.equals(user.getEmail(), email)){
            Optional <User> optionalEmail = userRepository.findByEmail(user.getEmail());
            if (optionalEmail.isPresent()){
                throw new IllegalStateException(email + " is already taken");
            }
            user.setEmail(email);
        }
    }


    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User " + userId + "does not exists");
        }
        userRepository.deleteById(userId);
    }
}

