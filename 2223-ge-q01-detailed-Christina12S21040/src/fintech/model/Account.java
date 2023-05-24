package fintech.model;

import java.util.ArrayList;

/**
 * @author 12S21025_Noni Jelia Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 */
public class Account {

    // class definition
    private String fullName;
    private String accountName;
    private double balance = 0.0;
    private ArrayList<Transaction> transaction = new ArrayList<>();

    public Account(String fullName, String accountName) {
        this.fullName = fullName;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void addTransaction(double amount, String timestamp, String memo) {
        Transaction newTrans = new Transaction(amount, timestamp, memo);
        this.balance += amount;
        this.transaction.add(newTrans);
    }

    @Override
    public String toString() {
        return this.fullName + "|" + this.accountName + "|" + balance;
    }
}