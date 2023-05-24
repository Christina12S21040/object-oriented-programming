package fintech.model;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

public class Transaction {

    private static int sequence = 0;
    private int id;
    private Account account1;
    private Account account2;
    private double amount;
    private String postedAt;
    private String note;

    public Transaction(Account account1, Account account2, double amount, String postedAt, String note) {
        // increment the sequence
        sequence++;
        this.id = sequence;
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note;
    }

    /* ACCESSOR */

    public Account getAccount1() {
        return account1;
    }

    public Account getAccount2() {
        return account2;
    }

    public double getAmount() {
        return amount;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public String detail() {
        if(account2 != null){
            return id + "|" +
                    account1.getName() + "|" +
                    account2.getName() + "|" +
                    amount + "|" +
                    postedAt + "|" +
                    note;
        }
        return id + "|" +
               account1.getName() + "|" +
               amount + "|" +
               postedAt + "|" +
               note;
    }

    @Override
    public String toString() {
        return id + "|" +
               account1.getName() + "|" +
               amount + "|" +
               postedAt + "|" +
               note + "|" +
               account1.getBalance();
    }

}