package fintech.model;

/**
 * @author 12S21025_Noni Jelia Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 */
public class Transaction {

    // class definition
    private double amount;
    private String timestamp;
    private String memo;

    public Transaction(double amount, String timestamp, String memo){
        this.amount = amount;
        this.timestamp = timestamp;
        this.memo = memo;
    }

}