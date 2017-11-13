package com.ericheitmuller.cards;

import com.ericheitmuller.cards.model.Card;

import java.util.List;

/**
 * Created by ericheitmuller on 11/8/17.
 */
public interface CardManager {
    List<Card> getAllCards();
    void saveCard(Card card);
}
