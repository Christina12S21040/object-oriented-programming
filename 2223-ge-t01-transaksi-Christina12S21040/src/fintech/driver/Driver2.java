package fintech.driver;
import java.util.*;
import fintech.model.*;
/**
 * @author 12S21025_Noni Jelia Feby Sipayung
 * @author 12S21040_Christina Putri Hutahaean

 */

public class Driver2 {


    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        

        // command
        String command1 = scanner.nextLine();
        // owner
        String owner = scanner.nextLine();
        // accountName
        String name = scanner.nextLine();
        // command2
        String command2 = scanner.nextLine();
        // accountName2
        String accountName = scanner.nextLine();
        // amount
        Double amount = scanner.nextDouble();
        // postedAt
        String posted_at =  scanner.nextLine();
        // note
        String note = scanner.nextLine();

       

        Account account = new Account(owner, name);
        Transaction transaction = new Transaction(name, amount, posted_at, note);

        System.out.println(account);
        System.out.println(transaction);
        scanner.close();

    }
}
