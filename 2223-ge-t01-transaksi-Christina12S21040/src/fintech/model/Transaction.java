package fintech.model;

import java.util.Date;

/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 *
 */
public class Transaction {

    // class definition
    private String owner;
    private double amount = 0.0;
    private String posted_at;
    private String note;
    

    public Transaction(String _owner, double _amount, String _posted_at, String _note ){
        this.owner = _owner;
        this.amount = _amount;
        this.posted_at = _posted_at;
        this.note = _note;
    }

    @Override
    public String toString() {
        return "1"+"|"+this.owner+"|"+this.amount+"|"+this.posted_at+"|"+this.note+"|"+this.amount;
    }

}
