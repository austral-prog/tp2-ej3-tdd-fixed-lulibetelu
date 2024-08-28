package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.template.App.deposit;

public class App {

    public static Map<String, Integer> createAccount(String account){
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put(account, 0);
        return accounts;
    }

    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        Map<String, Integer> updatedAccounts = new HashMap<>();
        for (Map.Entry<String, Integer> entry: accounts.entrySet()) {
            if ((amount >= 0) & (entry.getKey().equals(account))) {
                updatedAccounts.put(account, accounts.get(account) + amount);
            }
            else {
                updatedAccounts.put(entry.getKey(), entry.getValue());
            }
        }
        return updatedAccounts;
    }
    public static Map<String, Integer> withdrawal(Map<String, Integer> accounts, String account, int amount){
        Map<String, Integer> updatedAccounts = new HashMap<>();
        for (Map.Entry<String, Integer> entry: accounts.entrySet()) {
            if (amount >= 0 && entry.getKey().equals(account) && entry.getValue() > 0) {
                    updatedAccounts.put(account, accounts.get(account) - amount);
            }
            else {
                updatedAccounts.put(entry.getKey(), entry.getValue());
            }
        }
        return updatedAccounts;
    }
    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String account1, String account2, int amount){
        Map<String, Integer> updatedAccounts = new HashMap<>();
        if (accounts.containsKey(account1) & accounts.containsKey(account2)) {
            for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
                if (!(account1.equals(account2)) && accounts.get(account1) > 0 && amount > 0) {
                    if ((entry.getKey().equals(account1))) {
                        updatedAccounts.put(account1, accounts.get(account1) - amount);
                    } else if (entry.getKey().equals(account2)) {
                        updatedAccounts.put(account2, accounts.get(account2) + amount);
                    } else {
                        updatedAccounts.put(entry.getKey(), entry.getValue());
                    }
                } else {
                    updatedAccounts.put(entry.getKey(), entry.getValue());
                }
            }
        }
        else{
            updatedAccounts.putAll(accounts);
        }
       return updatedAccounts;

    }

}


