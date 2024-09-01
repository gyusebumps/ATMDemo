package org.demo;

import org.demo.controller.ATMController;
import org.demo.dao.Account;
import org.demo.dao.AccountManager;
import org.demo.dao.Card;

public class Main {
    public static void main(String[] args){
        Account account1 = new Account("12345", "Kate");
        account1.deposit("Savings", 1000);
        account1.deposit("Checking", 2000);

        Card card1 = new Card("12345", "Kate", "1111-1111-1111-1111", "123");

        AccountManager accManager = new AccountManager();
        accManager.addAccount(account1);
        accManager.addCard(card1);

        ATMController atmController = new ATMController(accManager);

        boolean inserted1 = atmController.insertCard("1111-1111-1111-1111", "1234");

        if(inserted1) {
            System.out.println("We have an existing card info in the system");
        } else {
            System.out.println("Invalid Card or Wrong PIN!");
        }

        boolean inserted2 = atmController.insertCard("1111-1111-1111-1111", "123");

        if(inserted2) {
            System.out.println("We have an existing card info in the system");
        } else {
            System.out.println("Invalid Card or Wrong PIN!");
        }

        int checkingBalance = atmController.checkCurrentBalance("Checking");
        int savingBalance = atmController.checkCurrentBalance("Savings");

        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Checking Account Balance: " + checkingBalance);
        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Savings Account Balance: " + savingBalance);

        atmController.deposit("Checking", 250);
        atmController.deposit("Savings", 250);

        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Checking Account Balance After Deposit: " + atmController.checkCurrentBalance("Checking"));
        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Savings Account Balance After Deposit: " + atmController.checkCurrentBalance("Savings"));

        atmController.withdraw("Checking", 2000);
        atmController.withdraw("Savings", 1000);

        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Checking Account Balance After Withdraw: " + atmController.checkCurrentBalance("Checking"));
        System.out.println(atmController.getInsertedCard().getName() + "'s " + "Savings Account Balance After Withdraw: " + atmController.checkCurrentBalance("Savings"));

        atmController.eject();
        Card currentCard = atmController.getInsertedCard();

        if(currentCard == null) {
            System.out.println("Cards got ejected from ATM");
        }
    }
}
