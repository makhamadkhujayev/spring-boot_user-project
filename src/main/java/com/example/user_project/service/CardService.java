package com.example.user_project.service;

import com.example.user_project.entity.Card;
import com.example.user_project.entity.User;
import com.example.user_project.repository.CardRepository;
import com.example.user_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Card> getCardsByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        return cardRepository.findAllByUserId(userId);
    }

}
