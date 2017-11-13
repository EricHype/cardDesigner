package com.ericheitmuller.cards.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by ericheitmuller on 11/8/17.
 */
public class Card {
    String name;
    CardType cardType;
    Integer manaCost;
    Integer health;
    Integer distance;
    String target;
    String cardImage;
    String cardText;
    String turnEffect;
    Integer equipmentSlots;
    Integer spellSlots;
    String abilityCost;
    String abilityTarget;
    String ability;
    String abilityDuration;
    String modifier;

    public Card(Document document){
        NodeList nList = document.getElementsByTagName("card");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                this.name = eElement.getElementsByTagName("name")
                        .item(0).getTextContent();
                this.cardType = CardType.valueOf(eElement.getElementsByTagName("cardType")
                        .item(0).getTextContent());
                this.manaCost = Integer.parseInt(eElement.getElementsByTagName("manaCost")
                        .item(0).getTextContent());
                this.health = Integer.parseInt(eElement.getElementsByTagName("health")
                        .item(0).getTextContent());
                this.distance = Integer.parseInt(eElement.getElementsByTagName("distance")
                        .item(0).getTextContent());
                this.target = eElement.getElementsByTagName("distance")
                        .item(0).getTextContent();
                this.cardImage = eElement.getElementsByTagName("cardImage")
                        .item(0).getTextContent();
                this.cardText = eElement.getElementsByTagName("cardText")
                        .item(0).getTextContent();
                this.turnEffect = eElement.getElementsByTagName("turnEffect")
                        .item(0).getTextContent();
                this.equipmentSlots = Integer.parseInt(eElement.getElementsByTagName("equipmentSlots")
                        .item(0).getTextContent());
                this.spellSlots = Integer.parseInt(eElement.getElementsByTagName("spellSlots")
                        .item(0).getTextContent());
                this.abilityCost = eElement.getElementsByTagName("abilityCost")
                        .item(0).getTextContent();
                this.abilityTarget = eElement.getElementsByTagName("abilityTarget")
                        .item(0).getTextContent();
                this.ability = eElement.getElementsByTagName("ability")
                        .item(0).getTextContent();
                this.abilityDuration = eElement.getElementsByTagName("abilityDuration")
                        .item(0).getTextContent();
                this.modifier = eElement.getElementsByTagName("modifier")
                        .item(0).getTextContent();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCardImage() {
        return cardImage;
    }

    public void setCardImage(String cardImage) {
        this.cardImage = cardImage;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getTurnEffect() {
        return turnEffect;
    }

    public void setTurnEffect(String turnEffect) {
        this.turnEffect = turnEffect;
    }

    public Integer getEquipmentSlots() {
        return equipmentSlots;
    }

    public void setEquipmentSlots(Integer equipmentSlots) {
        this.equipmentSlots = equipmentSlots;
    }

    public Integer getSpellSlots() {
        return spellSlots;
    }

    public void setSpellSlots(Integer spellSlots) {
        this.spellSlots = spellSlots;
    }

    public String getAbilityCost() {
        return abilityCost;
    }

    public void setAbilityCost(String abilityCost) {
        this.abilityCost = abilityCost;
    }

    public String getAbilityTarget() {
        return abilityTarget;
    }

    public void setAbilityTarget(String abilityTarget) {
        this.abilityTarget = abilityTarget;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getAbilityDuration() {
        return abilityDuration;
    }

    public void setAbilityDuration(String abilityDuration) {
        this.abilityDuration = abilityDuration;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String toXml(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<card>");
        stringBuilder.append("<name>" + this.name + "</name>");
        stringBuilder.append("<cardType>" + this.cardType.name() + "</cardType>");
        stringBuilder.append("<manaCost>" + this.manaCost + "</manaCost>");

        if(this.distance != null) {
            stringBuilder.append("<distance>" + this.distance + "</distance>");
        }
        if(this.target != null) {
            stringBuilder.append("<target>" + this.target + "</target>");
        }
        stringBuilder.append("<cardImage>" + this.cardImage + "</cardImage>");
        stringBuilder.append("<cardText>" + this.cardText + "</cardText>");

        if(this.turnEffect != null){
            stringBuilder.append("<turnEffect>" + this.turnEffect + "</turnEffect>");
        }
        if(this.health != null){
            stringBuilder.append("<health>" + this.health + "</health>");
        }
        if(this.equipmentSlots != null){
            stringBuilder.append("<equipmentSlots>" + this.equipmentSlots + "</equipmentSlots>");
        }
        if(this.spellSlots != null){
            stringBuilder.append("<spellSlots>" + this.spellSlots + "</spellSlots>");
        }
        if(this.abilityCost != null){
            stringBuilder.append("<abilityCost>" + this.abilityCost + "</abilityCost>");
        }
        if(this.abilityTarget != null){
            stringBuilder.append("<abilityTarget>" + this.abilityTarget + "</abilityTarget>");
        }
        if(this.ability != null){
            stringBuilder.append("<ability>" + this.ability + "</ability>");
        }
        if(this.abilityDuration != null){
            stringBuilder.append("<abilityDuration>" + this.abilityDuration + "</abilityDuration>");
        }
        if(this.modifier != null){
            stringBuilder.append("<modifier>" + this.modifier + "</modifier>");
        }

        stringBuilder.append("</card>");
        return stringBuilder.toString();
    }

}
