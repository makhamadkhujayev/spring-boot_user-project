package com.example.user_project.controller;

import com.example.user_project.entity.Card;
import com.example.user_project.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping(path = "{userId}")
    public List<Card> getCardByUserId(@PathVariable("userId") Long userId){
        return cardService.getCardsByUserId(userId);
    }
}
