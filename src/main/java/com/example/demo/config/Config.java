package com.example.demo.config;

import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, CardRepository cardRepository){
        return args -> {
          User user1 = new User("mike@gmail.com", "Mike", LocalDate.of(2000, Month.DECEMBER, 1));
          User user2 = new User("john@gmail.com", "John",  LocalDate.of(2002, Month.FEBRUARY, 3));
          userRepository.saveAll(List.of(user1, user2));
            Card card1 = new Card("Salary card", "03/28", 9860, user1);
            Card card2 = new Card("Salary card", "11/27", 8600, user1);
            cardRepository.saveAll(List.of(card1, card2));
        };
    }
}
