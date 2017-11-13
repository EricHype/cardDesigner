package com.ericheitmuller.deck.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by ericheitmuller on 11/7/17.
 */
public class Deck {
    String name;
    String cardLocation;

    public Deck(String name, String cardLocation) {
        this.name = name;
        this.cardLocation = cardLocation;
    }

    public Deck(Document doc){

        NodeList nList = doc.getElementsByTagName("deck");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                this.name = eElement.getElementsByTagName("name")
                        .item(0).getTextContent();
                this.cardLocation = eElement.getElementsByTagName("cardLocation")
                        .item(0).getTextContent();
            }
        }

    }

    public String toXml(){
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?> \n");
        builder.append("<deck> \n");
        builder.append("<name>" + this.name + "</name> \n");
        builder.append("<cardLocation>" + this.cardLocation + "</cardLocation> \n");
        builder.append("</deck> \n");
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public String getCardLocation() {
        return cardLocation;
    }
}
