package com.ericheitmuller.cards.impl;

import com.ericheitmuller.cards.CardManager;
import com.ericheitmuller.cards.model.Card;
import com.ericheitmuller.deck.model.Deck;
import com.ericheitmuller.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericheitmuller on 11/8/17.
 */
public class XmlCardManager implements CardManager {

    File file = null;

    public XmlCardManager(String cardDirectory){
        file = new File(cardDirectory);
        if(!file.exists()){
            file.mkdir();
        }
    }

    @Override
    public List<Card> getAllCards() {
        List<Card> retVal = new ArrayList<>();
        File[] files = file.listFiles();
        for(int i=0; i< files.length; i++){
            if(files[i].isDirectory()){
                continue;
            }

            retVal.add(new Card(FileUtil.readAllXmlFileText(files[i].getAbsolutePath())));
        }

        return retVal;
    }

    @Override
    public void saveCard(Card card) {
        File cardFile = new File(file, card.getName() + ".xml");

        try {
            if(!cardFile.exists()){
                cardFile.createNewFile();
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(cardFile.getAbsolutePath()), "utf-8"));
            writer.write(card.toXml());
            writer.close();

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
