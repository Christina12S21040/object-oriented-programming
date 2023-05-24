package fintech.model;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

 public class Account {
    private String nickname;
    private String namaakun;
    private double saldo;
  
    public Account(String nickname, String namaakun) {
      this.nickname = nickname;
      this.namaakun = namaakun;
      this.saldo = 0.0;
    }
  
    public String getNickname() {
      return this.nickname;
    }
  
    public String getNamaakun() {
      return this.namaakun;
    }
  
    public double getSaldo() {
      return this.saldo;
    }
  
    public void addSaldo(double amount) {
      this.saldo += amount;
    }
  
    public void kurangSaldo(double amount) {
      this.saldo -= amount;
    }
  
    @Override
    public String toString() {
      return this.getNamaakun() + "|" + this.getNickname() + "|" + String.format("%.1f", this.getSaldo());
    }
  }