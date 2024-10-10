package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
          User user1 = new User("mike@gmail.com", "Mike", LocalDate.of(2000, Month.DECEMBER, 1));
          User user2 = new User("john@gmail.com", "John",  LocalDate.of(2002, Month.FEBRUARY, 3));
          repository.saveAll(List.of(user1, user2));
        };
    }
}
