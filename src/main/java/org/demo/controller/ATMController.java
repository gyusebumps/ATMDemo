package org.demo.controller;

import org.demo.dao.Account;
import org.demo.dao.AccountManager;
import org.demo.dao.Card;

public class ATMController {

    private final AccountManager accountManager;
    private Card insertedCard;
    private Account linkedAccount;

    public ATMController(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public boolean insertCard(String cardNumber, String pin) {
        Card card = accountManager.getCardByCardNumber(cardNumber);
        if(card != null && card.getPIN().equals(pin)) {
            insertedCard = card;
            linkedAccount = accountManager.getAccountById(insertedCard.getId());
            return true;
        }
        return false;
    }

    public int checkCurrentBalance(String accountType) {
        return linkedAccount.getBalance(accountType);
    }

    public void deposit(String accountType, int balance) {
        linkedAccount.deposit(accountType, balance);
    }

    public void withdraw(String accountType, int balance) {
        linkedAccount.withdraw(accountType, balance);
    }
    
    public Card getInsertedCard() {
        return insertedCard;
    }
    
    public Account getLinkedAccount() {
        return linkedAccount;
    }
    
    public void eject() {
        insertedCard = null;
        linkedAccount = null;
    }
}
