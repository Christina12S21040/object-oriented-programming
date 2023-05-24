package fintech.model;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

public class Account {
    private String owner;
    private String name;
    private double balance;
    private Transaction[] transactions;

    public Account(String owner, String name) {
        this.owner = owner;
        this.name = name;
        this.balance = 0.0;
        this.transactions = new Transaction[0];
    }

    /* ACCESSOR */
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    // deal with transaction
    public void addTransaction(Transaction transaction) {
        // add the new transaction to
        // the transaction list
        transactions = Arrays.copyOfRange(transactions, 0, transactions.length + 1);
        transactions[transactions.length - 1] = transaction;

        // recalculate balance
        balance = balance + transaction.getAmount();
    }

    public String detail() {
        // store details as a string
        // set the first line as account's detail
        String detail = toString();

        // clone the transaction list in order to
        // preserve original transaction list state
        Transaction[] _transactions = transactions;

        // sort the new transaction lists
        // by comparing `postedAt` attribute
        Arrays.sort(_transactions, Comparator.comparing(Transaction::getPostedAt));

        // concatenate each transaction detail
        // to var `detail` with line feed char
        // at the beginning
        for (Transaction transaction: _transactions)
            detail += "\n" + transaction.detail();

        // return result
        return detail;
    }

    @Override
    public String toString() {
        return name + "|" + owner + "|" + balance;
    }
}