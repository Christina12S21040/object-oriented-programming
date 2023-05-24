package fintech.driver;
import java.util.Scanner;
import java.util.Arrays;
import fintech.model.Account;

/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 * 
 */
public class Driver1 {                         // untuk menunjukkan bahwa clasnya dapat diakses dari package lain
    static Account[] arcc = new Account[0]; // untuk menginialisasi objek arcc dari class account


    public static void main(String[] _args) {       //ini adalah fungsi mainnya

    Scanner scan = new Scanner(System.in);         // ini adalah inputan 
        Account acc;
        String[] words;
        String masukan;
        
        while (true) {
            masukan = scan.nextLine();   //untuk membaca inputan
            if (masukan.equals("---")) { //equals itu pengganti =
                break;
            }
            
            words = masukan.split("#"); //split itu untuk menambahkan tanda 
    
            if (words[0].equals("create-account")) {        // kegunaannya ini adalah jika tanda masukan diberikan 
                acc = new Account(words[1], words[2]);
                arcc = Arrays.copyOf(arcc, arcc.length+1);  //metod untuk mengcopy spesifikasi dari array
                arcc[arcc.length-1] = acc;                 // kegunaannya ini adalah ditambah satu agar nilai dari panjang 
            }
        }
        
        for (int i=0; i < arcc.length; i++) {
            System.out.println(arcc[i]);
        }
        scan.close();

    }

}