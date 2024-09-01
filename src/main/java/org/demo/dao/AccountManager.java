package org.demo.dao;

import java.util.Map;
import java.util.HashMap;

public class AccountManager {
    private Map<String, Account> accounts;
    private Map<String, Card> cards;

    public AccountManager() {
        accounts = new HashMap<>();
        cards = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public void addCard(Card card) {
        cards.put(card.getId(), card);
    }

    public Account getAccountById(String id) {
        return accounts.get(id);
    }

    public Card getCardById(String id) {
        return cards.get(id);
    }

    public Card getCardByCardNumber(String cardNumber) {
        for(Card card : cards.values()) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }
}
