package fintech.driver;

import fintech.model.Account;

import java.util.ArrayList;

/**
 * @author 12S21025_Noni Jelia Sipayung
 * @author 12S21040_Christina Putri Hutahaean
 */
public class Driver2 {

    public static void main(String[] _args) {

        // codes
        ArrayList<String> commands = new ArrayList<String>(); // Create an ArrayList object
        ArrayList<Account> accounts = new ArrayList<>();

        commands.add("create-account#Wiro Sableng#wirsab"); //command1
        commands.add("create-account#Jaka Sembung#jaksem"); //command2
        commands.add("create-transaction#jaksem#15.0#2023/02/14 14:14:14#Weekly income"); //command3
        commands.add("create-transaction#jaksem#-8.4#2023/02/15 15:18:15#SIM credit"); //command4
        commands.add("create-transaction#jaksem#37.1#2023/02/15 15:15:15#Book refund"); //command5
        commands.add("create-transaction#wirsab#-5.0#2023/02/16 10:15:41#Tax"); //command6
        commands.add("show-account"); //command7

        for(String command : commands){
            String[] arrOfStr = command.split("#");

            if(arrOfStr[0].equals("create-account")){
                Account account = new Account(arrOfStr[1], arrOfStr[2]); //Account(fullName, accountName)
                accounts.add(account);
            }
            else if (arrOfStr[0].equals("create-transaction")) {
                for(Account account : accounts){
                    if(account.getAccountName().equals(arrOfStr[1])){
                        account.addTransaction(Double.parseDouble(arrOfStr[2]), arrOfStr[3], arrOfStr[4]);
                    }
                }
            }
            else if (arrOfStr[0].equals("show-account")){
                accounts.sort((o1, o2) -> o1.getAccountName().compareTo(o2.getAccountName()));
                for (Account account : accounts){
                    System.out.println(account.toString());
                }
            }
        }
    }

}