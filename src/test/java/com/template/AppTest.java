package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void createAccount(){
        Map<String, Integer> accounts = App.createAccount("mati");
        assertEquals(0, accounts.get("mati"));
    }
    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }
    @Test
    void negativeDeposit(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", -5);
        assertEquals(10, updatedAccounts.get("mati"));

    }
    @Test
    void unknownDeposit(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "nico", 5);
        assertEquals(accounts, updatedAccounts);

    }
    @Test
    void testWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }
    @Test
    void negativeWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }
    @Test
    void emptyWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 0, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "mati", 5);
        assertEquals(0, updatedAccounts.get("mati"));
    }
    @Test
    void unknownWithdrawal(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdrawal(accounts, "nico", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void testTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "jaun", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(25, updatedAccounts.get("jaun"));
    }
    @Test
    void emptyTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 0, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "jaun", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void unknownTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "nico", "jaun", 5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void negativeTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "jaun", -5);
        assertEquals(accounts, updatedAccounts);
    }
    @Test
    void autoTransfer(){
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "mati", 5);
        assertEquals(accounts, updatedAccounts);
    }
}
