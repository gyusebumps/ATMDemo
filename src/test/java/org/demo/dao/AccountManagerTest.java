package org.demo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountManagerTest {

    private AccountManager accountManager;
    private Card card;
    private Account account;

    @BeforeEach
    public void setUp() {
        accountManager = new AccountManager();
        card = new Card("123", "Jason", "1111-2222-3333-4444", "111");
        account = new Account("123", "Jason");
    }

    @Test
    public void getAccountById() {
        accountManager.addAccount(account);
        assertEquals(accountManager.getAccountById(account.getId()), account);
    }

    @Test
    public void getCardById() {
        accountManager.addCard(card);
        assertEquals(accountManager.getCardById(card.getId()), card);
    }

    @Test
    public void getCardByValidCardNumber() {
        accountManager.addCard(card);
        assertEquals(accountManager.getCardByCardNumber(card.getCardNumber()), card);
    }

    @Test
    public void getCardByInvalidCardNumber() {
        Card invalidCard = new Card("112", "Sophia", "1111-2222-3333-5555", "131");
        assertNull(accountManager.getCardByCardNumber(invalidCard.getCardNumber()));
    }
}