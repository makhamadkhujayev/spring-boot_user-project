package com.example.user_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    private String cardName;
    private String expiryDate;
    private Integer cardNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Card(String cardName, String expiryDate, Integer cardNumber, User user) {
        this.cardName = cardName;
        this.expiryDate = expiryDate;
        this.cardNumber = cardNumber;
        this.user = user;
    }
}
