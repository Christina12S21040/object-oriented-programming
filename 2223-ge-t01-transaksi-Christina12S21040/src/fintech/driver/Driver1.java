package fintech.driver;
import java.util.*;
import fintech.model.*;
/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean

 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner scanner = new                                                                                                                                                                                  c'
        
        xScanner(System.in);

        // command
        String command = scanner.nextLine();
        // owner
        String owner = scanner.nextLine();
        // account.name
        String name = scanner.nextLine();

        Account account = new Account(owner, name);

        System.out.println(account);
        scanner.close();

    }
}
