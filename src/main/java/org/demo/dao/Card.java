package org.demo.dao;

public class Card {

    private String id;
    private String name;
    private String cardNumber;
    private String pin;

    public Card(String id, String name, String cardNumber, String pin) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public String getPIN() {
        return this.pin;
    }

    public void setPIN(String newPin) {
        this.pin = newPin;
    }
}
