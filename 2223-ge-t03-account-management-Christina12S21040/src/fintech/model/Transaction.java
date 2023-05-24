package fintech.model;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

public class Transaction {

    private static int sequence = 0;
    private int id;
    private Account account;
    private double amount;
    private String postedAt;
    private String note;

    public Transaction(Account account, double amount, String postedAt, String note) {
        // increment the sequence
        sequence++;
        this.id = sequence;
        this.account = account;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note;
    }

    /* ACCESSOR */
    public double getAmount() {
        return amount;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public String detail() {
        return id + "|" +
               account.getName() + "|" +
               amount + "|" +
               postedAt + "|" +
               note;
    }

    @Override
    public String toString() {
        return id + "|" +
               account.getName() + "|" +
               amount + "|" +
               postedAt + "|" +
               note + "|" +
               account.getBalance();
    }

}