package fintech.model;

import java.util.Date;

public class Revert extends Transaction {
  int revert;

  public Revert(int identifiertransaksi, String namaakun, double jumlah, Date tanggal,
      String catatan, int revert) {
    super(identifiertransaksi, namaakun, jumlah, tanggal, catatan);
    this.revert = revert;
  }

  public int getRevert() {
    return this.revert;
  }

  @Override
  public String toString() {
    return this.getIdentifiertransaksi() + "|" + this.getNamaakun() + "|"
        + String.format("%.1f", this.getJumlah()) + "|" + this.getTanggal()
        + "|REVERT: " + this.getCatatan();
  }
}
