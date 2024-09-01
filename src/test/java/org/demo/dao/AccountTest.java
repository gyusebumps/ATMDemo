package org.demo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("1234", "Jason");
    }

    @Test
    public void getId() {
        assertEquals("1234", account.getId());
    }

    @Test
    public void getName() {
        assertEquals("Jason", account.getName());
    }

    @Test
    public void deposit() {
        account.deposit("Checking", 3000);
        assertEquals(account.getBalance("Checking"), 3000);

        account.deposit("Savings", 1500);
        assertEquals(account.getBalance("Savings"), 1500);
    }

    @Test
    public void withdrawWithInvalidAmount() {
        account.deposit("Checking", 3000);

        assertFalse(account.withdraw("Checking", 3100));
    }

    @Test
    public void withdrawWithValidAmount() {
        account.deposit("Checking", 3000);

        assertTrue(account.withdraw("Checking", 1500));
        assertEquals(account.getBalance("Checking"), 1500);
    }
}