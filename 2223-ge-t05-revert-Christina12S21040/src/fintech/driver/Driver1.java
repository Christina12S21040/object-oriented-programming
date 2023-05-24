package fintech.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Comparator;
import java.util.*;
import fintech.model.*;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */


public class Driver1 {
  public static void main(String[] args) {
    DateFormat formattanggal = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    HashMap<String, Account> banyakakun = new HashMap<>();
    Scanner inputan = new Scanner(System.in);
    int identifiertransaksi = 1;
    HashMap<String, Transaction> banyaktransaksi = new HashMap<>();

    while (true) {
      String input = inputan.nextLine();
      if (input.equals("---")) {
        break;
      }

      String[] inputArr = input.split("#");

      if (inputArr[0].equals("remove-account")) {
        removeAccount(inputArr[1].toLowerCase(), banyakakun, banyaktransaksi);
      } 
      else if (inputArr[0].equals("create-account")) {
        createAccount(inputArr[1], inputArr[2], banyakakun);
      } 
      else if (inputArr[0].equals("show-account")) {
        showAccount(inputArr[1], banyakakun, banyaktransaksi);
      } 
      else if (inputArr[0].equals("show-accounts")) {
        showAccounts(banyakakun, banyaktransaksi);
      } 
      else if (inputArr[0].equals("create-transaction")) {
        
        if (banyakakun.containsKey(inputArr[2].toLowerCase())) {
          if (createTransferTransaction(inputArr[1], inputArr[2], inputArr[3], inputArr[4], inputArr[5], banyakakun,
              banyaktransaksi,
              formattanggal, identifiertransaksi)) {
            identifiertransaksi++;
          }
        } 
        else {
          if (createTransaction(inputArr[1], inputArr[2], inputArr[3], inputArr[4], banyakakun, banyaktransaksi,
              formattanggal, identifiertransaksi)) {
            identifiertransaksi++;
          }
        }
      } else if (inputArr[0].equals("revert-transaction")) {
        if (createRevertTransaction(inputArr[1], Integer.parseInt(inputArr[2]), inputArr[3], banyakakun,
            banyaktransaksi,
            formattanggal, identifiertransaksi)) {
          identifiertransaksi++;
        }
      }
    }
  }

  public static void removeAccount(String accountName, HashMap<String, Account> banyakakun,
      HashMap<String, Transaction> banyaktransaksi) {
    if (banyakakun.containsKey(accountName.toLowerCase())) {
      banyakakun.remove(accountName.toLowerCase());
      List<Transaction> listtransaksi = new ArrayList<>(banyaktransaksi.values());
      for (Transaction transaksii : listtransaksi) {
        if (transaksii.getTarget() != null && transaksii.getTarget().toLowerCase().equals(accountName.toLowerCase())) {
          banyaktransaksi.remove(transaksii.getIdentifiertransaksi());
        }
      }
    }
  }

  public static void createAccount(String owner, String accountName, HashMap<String, Account> banyakakun) {
    if (!banyakakun.containsKey(accountName.toLowerCase())) {
      Account akunn = new Account(owner, accountName);
      banyakakun.put(accountName.toLowerCase(), akunn);
      System.out.println(akunn);
    }
  }

  public static void showAccount(String accountName, HashMap<String, Account> banyakakun,
      HashMap<String, Transaction> banyaktransaksi) {
    if (banyakakun.containsKey(accountName.toLowerCase())) {
      Account akunn = banyakakun.get(accountName.toLowerCase());
      System.out.println(akunn);
      List<Transaction> listtransaksi = new ArrayList<>(banyaktransaksi.values());
      Collections.sort(listtransaksi, Comparator.comparing(Transaction::getTanggal));
      for (Transaction transaksii : listtransaksi) {
        if (transaksii.getTarget() == null
            && transaksii.getNamaakun().toLowerCase().equals(accountName.toLowerCase())) {
          System.out.println(transaksii);
        } else if (transaksii.getNamaakun().toLowerCase().equals(accountName.toLowerCase())
            || transaksii.getTarget() != null
                && transaksii.getTarget().toLowerCase().equals(accountName.toLowerCase())) {
          System.out.println(transaksii);
        }
      }
    }
  }

  public static void showAccounts(HashMap<String, Account> banyakakun, HashMap<String, Transaction> banyaktransaksi) {
    List<Transaction> listtransaksi = new ArrayList<>(banyaktransaksi.values());
    Collections.sort(listtransaksi, Comparator.comparing(Transaction::getTanggal));
    List<Account> listaccount = new ArrayList<>(banyakakun.values());
    Collections.sort(listaccount, Comparator.comparing(Account::getNickname));
    for (Account akunn : listaccount) {
      System.out.println(akunn);
      for (Transaction transaksii : listtransaksi) {
        if (transaksii.getTarget() == null
            && transaksii.getNamaakun().toLowerCase().equals(akunn.getNamaakun().toLowerCase())) {
          System.out.println(transaksii);
        } else if (transaksii.getNamaakun().toLowerCase().equals(akunn.getNamaakun().toLowerCase())
            || transaksii.getTarget() != null
                && transaksii.getTarget().toLowerCase().equals(akunn.getNamaakun().toLowerCase())) {
          System.out.println(transaksii);
        }
      }
    }
  }

  public static Boolean createTransaction(String accountName, String amountStr, String posted_atStr, String description,
      HashMap<String, Account> banyakakun, HashMap<String, Transaction> banyaktransaksi, DateFormat formattanggal,
      int identifiertransaksi) {
    double amount = Double.parseDouble(amountStr);
    Date posted_at = null;
    try {
      posted_at = formattanggal.parse(posted_atStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (banyakakun.containsKey(accountName.toLowerCase())) {
      Account akunn = banyakakun.get(accountName.toLowerCase());
      try {
        if (amount < 0 && akunn.getSaldo() + amount > 0) {
          throw new Exception("True");
        } else if (amount > 0) {
          throw new Exception("True");
        } else {
          throw new Exception("False");
        }
      } catch (Exception e) {
        if (e.getMessage().equals("True")) {
          akunn.addSaldo(amount);
          Transaction transaksii = new Transaction(identifiertransaksi, accountName.toLowerCase(), amount, posted_at,
              description);
          banyaktransaksi.put(UUID.randomUUID().toString(), transaksii);
          return true;
        }
      }
    }
    return false;
  }

  public static Boolean createTransferTransaction(String accountName, String accountTarget, String amountStr,
      String posted_atStr, String description, HashMap<String, Account> banyakakun,
      HashMap<String, Transaction> banyaktransaksi, DateFormat formattanggal, int identifiertransaksi) {
    double amount = Double.parseDouble(amountStr);
    Date posted_at = null;
    try {
      posted_at = formattanggal.parse(posted_atStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (banyakakun.containsKey(accountName.toLowerCase())) {
      Account akunn = banyakakun.get(accountName.toLowerCase());
      try {
        if (amount > 0 && akunn.getSaldo() - amount > 0) {
          throw new Exception("True");
        } else {
          throw new Exception("False");
        }
      } catch (Exception e) {
        if (e.getMessage().equals("True")) {
          akunn.kurangSaldo(amount);
          Transfer transaksii = new Transfer(identifiertransaksi, accountName.toLowerCase(), accountTarget, amount,
              posted_at, description);
          banyaktransaksi.put(UUID.randomUUID().toString(), transaksii);
          if (banyakakun.containsKey(accountTarget.toLowerCase())) {
            Account akunn2 = banyakakun.get(accountTarget.toLowerCase());
            akunn2.addSaldo(amount);
          }
          return true;
        }
      }
    }
    return false;
  }

  public static Boolean createRevertTransaction(String accountName, int revert, String posted_atStr,
      HashMap<String, Account> banyakakun, HashMap<String, Transaction> banyaktransaksi, DateFormat formattanggal,
      int identifiertransaksi) {
    Date posted_at = null;
    try {
      posted_at = formattanggal.parse(posted_atStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (banyakakun.containsKey(accountName.toLowerCase())) {
      Account akunn = banyakakun.get(accountName.toLowerCase());
      List<Transaction> listtransaksi = new ArrayList<>(banyaktransaksi.values());
      for (Transaction transaksii : listtransaksi) {
        if (transaksii.getIdentifiertransaksi() == revert) {
          double amount = transaksii.getJumlah() * (-1);
          try {
            if (amount < 0 && akunn.getSaldo() + amount > 0) {
              throw new Exception("True");
            } else if (amount > 0) {
              throw new Exception("True");
            } else {
              throw new Exception("False");
            }
          } catch (Exception e) {
            if (e.getMessage().equals("True")) {
              akunn.addSaldo(amount);
              Transaction transaksiirevert = new Revert(identifiertransaksi, accountName.toLowerCase(), amount,
                  posted_at, transaksii.getCatatan(), revert);
              banyaktransaksi.put(UUID.randomUUID().toString(), transaksiirevert);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}