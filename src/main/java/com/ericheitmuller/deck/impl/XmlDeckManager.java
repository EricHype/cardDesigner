package com.ericheitmuller.deck.impl;

import com.ericheitmuller.deck.DeckManager;
import com.ericheitmuller.deck.model.Deck;
import com.ericheitmuller.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericheitmuller on 11/7/17.
 */
public class XmlDeckManager implements DeckManager {

    //todo: move the location to config property
    File file = new File("./Decks");

    public XmlDeckManager(){
        if (!file.exists()) {
            System.out.println("making main deck directory");
            file.mkdir();
        }
    }

    public List<Deck> loadAllDecks() {
        List<Deck> decks = new ArrayList<>();
        File[] files = file.listFiles();
        for(int i=0; i< files.length; i++){
            if(files[i].isDirectory()){
                continue;
            }

            decks.add(new Deck(FileUtil.readAllXmlFileText(files[i].getAbsolutePath())));
        }

        return decks;
    }

    public void saveDeck(Deck deck) {


        File deckFile = new File(file, deck.getName() + ".xml");

        try {
            if(!deckFile.exists()){
                deckFile.createNewFile();
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(deckFile.getAbsolutePath()), "utf-8"));
            writer.write(deck.toXml());
            writer.close();

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}
