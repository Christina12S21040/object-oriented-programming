package fintech.model;

/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 * 
 */
public class Account {

    // class definition
    private final String owner;
    private final String name;
    private double balance = 0.0;

    public Account(String _owner, String _name){
        this.owner = _owner;
        this.name = _name;
    }

     public String getOwner() {
    return owner;
}
    public String getName() {
        return name;
    }
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        
    return this.name+"|"+this.owner+"|"+this.balance;
    }


}

