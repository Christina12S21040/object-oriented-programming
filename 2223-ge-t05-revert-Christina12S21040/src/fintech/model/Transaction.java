package fintech.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

 public class Transaction {
    private int identifiertransaksi;
    private String namaakun;
    private double jumlah;
    private Date tanggal;
    private String catatan;
  
    public Transaction(int identifiertransaksi, String namaakun, double jumlah, Date tanggal, String catatan) {
      this.identifiertransaksi = identifiertransaksi;
      this.namaakun = namaakun;
      this.jumlah = jumlah;
      this.tanggal = tanggal;
      this.catatan = catatan;
    }
  
    public int getIdentifiertransaksi() {
      return this.identifiertransaksi;
    }
  
    public String getNamaakun() {
      return this.namaakun;
    }
  
    public double getJumlah() {
      return this.jumlah;
    }
  
    public String getTanggal() {
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      String outputDate = dateFormat.format(this.tanggal);
      return outputDate;
    }
  
    public String getCatatan() {
      return this.catatan;
    }
  
    @Override
    public String toString() {
      return this.getIdentifiertransaksi() + "|" + this.getNamaakun() + "|" + String.format("%.1f", this.getJumlah())
          + "|" + this.getTanggal()
          + "|" + this.getCatatan();
    }
  
    public String getTarget() {
      return null;
    }
  }