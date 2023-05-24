package fintech.driver;
import fintech.model.*;
import java.util.*;

/**
 * @author 12S21025-Noni Jelia Feby Sipayung
 * @author 12S21040-Christina Putri Hutahean
 */

 

public class Driver1 {
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        String input = new String();

        while (true) {
            input = scanner.nextLine();

            if (input.equals("---"))
                break;

            String[] data = input.split("#");
            String command = data[0];
            data = Arrays.copyOfRange(data, 1, data.length);

            Account tmp = null;

            switch (command) {
                case "create-account":
                    if (findAccount(data[1]) == null) {
                        Account account = new Account(data[0], data[1]);
                        System.out.println(account);
                        accounts.add(account);
                    }
                    break;

                case "show-accounts":
                    ArrayList<Account> population = new ArrayList<>(accounts);
                    population.sort(Comparator.comparing(left -> left.getName().toLowerCase()));
                    for (Account account: population)
                        System.out.println(account.detail());
            }
                    break;

        scanner.close();
    }
        }
    }


