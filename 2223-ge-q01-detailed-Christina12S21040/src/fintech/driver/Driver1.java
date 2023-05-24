package fintech.driver;
import java.util.Scanner;
import java.util.Arrays;
import fintech.model.Account;

/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 * 
 */

public class Driver1 {

    static Account[] arcc = new Account[0];

    public static void main(String[] _args) {

        Scanner scan = new Scanner(System.in);
        Account acc;
        String[] words;
        String masukan;
        String[] temp;

        while (true) {
            masukan = scan.nextLine();
            if (masukan.equals("---")) {
                break;
            }

            words = masukan.split("#");

            if (words[0].equals("create-account")) {
                acc = new Account(words[1], words[2]);
                system.out.println(acc);
                arcc = Arrays.copyOf(arcc, arcc.length+1);
                arcc[arcc.length-1] = acc;

            }
            else if (words[0].equals("find-account")) {
                for(int i =0; i<arcc.length; i++){
                    if(arcc[i].name.equalsIgnoreCase(words[1])){
                        System.out.println(arcc[i]);
                    }else {
                        continue;
                    }
                }
            }

            System.out.println(arcc[i]);
        }
        scan.close();
    }
    }