package org.demo.dao;
import java.util.Map;
import java.util.HashMap;

public class Account {
    private String id;
    private String name;
    private Map<String, Integer> accBalances;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
        this.accBalances = new HashMap<>();
        this.accBalances.put("Savings", 0);
        this.accBalances.put("Checking", 0);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance(String accountType) {
        return this.accBalances.getOrDefault(accountType, 0);
    }

    public void deposit(String accountType, int amount) {
        this.accBalances.put(accountType, this.accBalances.get(accountType) + amount);
    }

    public boolean withdraw(String accountType, int amount) {
        if(getBalance(accountType) >= amount) {
            this.accBalances.put(accountType, this.accBalances.get(accountType) - amount);
            return true;
        }
        return false;
    }
}
