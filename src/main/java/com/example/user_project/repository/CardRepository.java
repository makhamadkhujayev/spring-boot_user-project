package com.example.user_project.repository;

import com.example.user_project.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository <Card, Long> {
    List<Card> findAllByUserId(Long userId);
}
