package com.example.user_project.config;

import com.example.user_project.entity.Card;
import com.example.user_project.entity.Role;
import com.example.user_project.entity.RoleEntity;
import com.example.user_project.entity.User;
import com.example.user_project.repository.CardRepository;
import com.example.user_project.repository.RoleEntityRepository;
import com.example.user_project.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, CardRepository cardRepository, RoleEntityRepository roleEntityRepository){
        return args -> {
            RoleEntity role1 = new RoleEntity(Role.USER);
            RoleEntity role2 = new RoleEntity(Role.ADMIN);
            roleEntityRepository.saveAll(List.of(role1, role2));
            User user1 = new User("mike@gmail.com", "Mike", LocalDate.of(2000, Month.DECEMBER, 1), List.of(role1, role2));
            User user2 = new User("john@gmail.com", "John",  LocalDate.of(2002, Month.FEBRUARY, 3), List.of(role2));
            userRepository.saveAll(List.of(user1, user2));
            Card card1 = new Card("Salary card", "03/28", 9860, user1);
            Card card2 = new Card("Salary card", "11/27", 8600, user1);
            cardRepository.saveAll(List.of(card1, card2));
        };
    }
}
