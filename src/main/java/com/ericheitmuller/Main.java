package com.ericheitmuller;

import com.ericheitmuller.cards.CardManager;
import com.ericheitmuller.cards.impl.XmlCardManager;
import com.ericheitmuller.deck.DeckManager;
import com.ericheitmuller.deck.impl.XmlDeckManager;
import com.ericheitmuller.deck.model.Deck;

import java.util.List;

/**
 * Created by ericheitmuller on 11/7/17.
 */
public class Main {
    public static void main(String[] args) {
        DeckManager mgr = new XmlDeckManager();
        mgr.loadAllDecks();

        Deck deck = new Deck("Test Deck", "./Deck/Test Deck Cards");
        mgr.saveDeck(deck);
        //Deck deck2 = new Deck("Test Deck2", "./Deck/Test Deck2 Cards");
        //mgr.saveDeck(deck2);
        //Deck deck3 = new Deck("Test Deck3", "./Deck/Test Deck3 Cards");
        //mgr.saveDeck(deck3);

        //List<Deck> allDecks = mgr.loadAllDecks();
        //for(Deck d : allDecks) {
        //    System.out.println(d.getName() + " " + d.getCardLocation());
        //}

        CardManager cardManager = new XmlCardManager(deck.getCardLocation());
    }
}
