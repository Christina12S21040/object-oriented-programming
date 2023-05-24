package fintech.model;

import java.util.Date;

public class Transfer extends Transaction {
  String target;

  public Transfer(int identifiertransaksi, String namaakun, String target, double jumlah, Date tanggal,
      String catatan) {
    super(identifiertransaksi, namaakun, jumlah, tanggal, catatan);
    this.target = target;
  }

  public String getTarget() {
    return this.target;
  }

  @Override
  public String toString() {
    return this.getIdentifiertransaksi() + "|" + this.getNamaakun() + "|" + this.getTarget() + "|" + String.format("%.1f", this.getJumlah()) + "|" + this.getTanggal()
        + "|" + this.getCatatan();
  }
}
