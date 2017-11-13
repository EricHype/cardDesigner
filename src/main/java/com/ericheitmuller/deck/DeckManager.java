package com.ericheitmuller.deck;

import com.ericheitmuller.deck.model.Deck;

import java.util.List;

/**
 * Created by ericheitmuller on 11/7/17.
 */
public interface DeckManager {
    List<Deck> loadAllDecks();
    void saveDeck(Deck deck);
}
