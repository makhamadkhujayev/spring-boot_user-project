package com.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private User user;
}
