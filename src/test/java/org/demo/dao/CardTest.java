package org.demo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    private Card card;

    @BeforeEach
    public void setUp() {
        card = new Card("123", "Jason", "1111-2222-3333-4444", "111");
    }

    @Test
    public void getId() {
        assertEquals(card.getId(), "123");
    }

    @Test
    public void getName() {
        assertEquals(card.getName(), "Jason");
    }

    @Test
    public void getCardNumber() {
        assertEquals(card.getCardNumber(), "1111-2222-3333-4444");
    }

    @Test
    public void getPIN() {
        assertEquals(card.getPIN(), "111");
    }

    @Test
    public void setPIN() {
        card.setPIN("222");
        assertEquals(card.getPIN(), "222");
    }
}