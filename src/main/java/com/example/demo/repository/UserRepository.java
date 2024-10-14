package com.example.demo.repository;

import com.example.demo.entity.Card;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<Card>  findCardsByUserId(Long userId);
    List<Card> findAllByUserId(Long userId);
}
