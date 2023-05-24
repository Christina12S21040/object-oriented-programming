package fintech.model;   

/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 * 
 */

public class Account {
    private String owner;
    public String name;
    private double balance;

    public  Account() {
        this.owner = "";     //ini untuk menginiliasisasi variable
        this.name = "";
        this.balance = 0.0;
    }

    public Account(String owner, String name) {
        this.owner = owner;
        this.name = name;
        this.balance = 0.0;
    }
    public String getOwner() {   //ini suatu metod untuk mengembalikan nilai string 
        return owner;
    }

    public String getName() {
        return name;
    }

     public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return this.name + "|" + this.owner + "|" + this.balance;
    }
}