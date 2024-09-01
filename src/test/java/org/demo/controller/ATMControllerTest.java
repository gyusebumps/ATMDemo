package org.demo.controller;

import org.demo.dao.Account;
import org.demo.dao.AccountManager;
import org.demo.dao.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ATMControllerTest {

    private ATMController atmController;
    private AccountManager accountManager;
    private Card card;
    private Account account;

    @BeforeEach
    public void setUp() {
        accountManager = new AccountManager();
        card = new Card("123", "Jason", "1111-2222-3333-4444", "111");
        account = new Account("123", "Jason");
        accountManager.addAccount(account);
        accountManager.addCard(card);
        atmController = new ATMController(accountManager);
    }

    @Test
    public void insertCardWithValidPin() {
        assertTrue(atmController.insertCard("1111-2222-3333-4444", "111"));
    }

    @Test
    public void insertCardWithInvalidPin() {
        assertFalse(atmController.insertCard("1111-2222-3333-4444", "121"));
    }

    @Test
    public void deposit() {
        atmController.insertCard("1111-2222-3333-4444", "111");
        atmController.deposit("Savings", 1000);
        assertEquals(atmController.checkCurrentBalance("Savings"), 1000);
    }

    @Test
    public void withdraw() {
        atmController.insertCard("1111-2222-3333-4444", "111");
        atmController.deposit("Checking", 1000);
        atmController.withdraw("Checking", 500);
        assertEquals(atmController.checkCurrentBalance("Checking"), 500);
    }

    @Test
    public void getInsertedCard() {
        atmController.insertCard("1111-2222-3333-4444", "111");
        assertEquals(card, atmController.getInsertedCard());
    }

    @Test
    public void getLinkedAccount() {
        atmController.insertCard("1111-2222-3333-4444", "111");
        assertEquals(account, atmController.getLinkedAccount());
    }

    @Test
    public void eject() {
        atmController.eject();
        assertNull(atmController.getLinkedAccount());
        assertNull(atmController.getInsertedCard());
    }
}