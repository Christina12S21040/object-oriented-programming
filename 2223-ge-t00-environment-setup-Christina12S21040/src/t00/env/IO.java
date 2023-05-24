package t00.env;
import java.util.Scanner;
/**
 * @author 12S21040_Christina Putri Hutahaean
 * 
 * 
 */
public class IO {
     public static void main(String[] _args)
     {
        Scanner scan = new Scanner(System.in);

        String NIM = scan.nextLine();
        String Nama = scan.nextLine();

        System.out.printf(NIM+"|"+Nama);
    }
}