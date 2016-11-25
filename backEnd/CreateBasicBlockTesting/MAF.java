import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.Collections;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
* This class is responsible for maintaining a hashmap of valid accounts.
* It also contains functions for reading in a Master Account File and writing
* new Master Account Files and Valid Account Files.
*/
public final class MAF {
    private static Map<String, Account> accounts;
    private static BufferedReader br;

    private MAF() { }


    /**
    * This function loads a MAF into the accounts hashmap.
    * Program ends if read is unsuccessful.
    * @param fileName name of the MAF to load
    * @return true if loaded successfully
    */
    public static Boolean load(String fileName) {
        System.out.println("BLOCK: 11 (MAF load)");
        try {
            System.out.println("BLOCK: 12 (MAF load try)");
            br = new BufferedReader(new FileReader(fileName));
        } catch(IOException e) {
            System.out.println("BLOCK: 13 (MAF load catch)");
            System.out.println("ERROR: " + fileName + " is not a file.");
            System.exit(1);
        }
        System.out.println("BLOCK: 14 (MAF post try)");
        accounts = new HashMap<String, Account>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            System.out.println("BLOCK: 15 (MAF try two)");
      		stream.forEach(line -> {
                System.out.println("BLOCK: 16 (MAF foreach)");
                String[] parse = parseLine(line);
                Account account = new Account(parse[0],
                                              parse[2],
                                              Integer.parseInt(parse[1]));
                accounts.put(parse[0], account);
            });
            System.out.println("BLOCK: 17 (MAF post foreach)");
		} catch(IOException e) {
            System.out.println("BLOCK: 18 (MAF catch two)");
			System.out.println("ERROR: Unable to read file " + fileName + ".");
      System.exit(1);
		}
        System.out.println("BLOCK: 19 (MAF post catch two)");

		return true;
    }

    /**
    * This function writes the contents of the accounts hashmap to a MAF file.
    * The lines are sorted by account number in ascending order.
    * @param fileName name of the file to create
    * @return true if the write was successful
    */
    public static Boolean generateMasterAccountsList(String fileName) {
        System.out.println("BLOCK: 20 (generateMasterAccountsList)");
        ArrayList<Account> accountList
            = new ArrayList<Account>(accounts.values());
        ArrayList<String> accountNumberList = new ArrayList<String>();

        for (int i = 0; i < accountList.size(); i++) {
            System.out.println("BLOCK: 21 "
                             + "(generateMasterAccountsList for loop)");
            accountNumberList.add(accountList.get(i).getAccountNumber() + " " +
                                  accountList.get(i).getAccountBalance() + " " +
                                  accountList.get(i).getAccountName());
        }
        System.out.println("BLOCK: 22 (generateMasterAccountsList post loop)");

        Collections.sort(accountNumberList);

        return writeToFile(fileName, accountNumberList);
    }

    /**
    * This function writes the contents of the accounts hashmap to a VAL file.
    * The numbers have no obligation to be sorted.
    * @param fileName name of the file to create
    * @return true if the write was successful
    */
    public static Boolean generateValidAccountsList(String fileName) {
        System.out.println("BLOCK: 23 (generateValidAccountsList)");
        ArrayList<Account> accountList
            = new ArrayList<Account>(accounts.values());
        ArrayList<String> accountNumberList = new ArrayList<String>();

        for (int i = 0; i < accountList.size(); i++) {
            System.out.println("BLOCK: 24 "
                               + "(generateValidAccountsList for loop)");
            accountNumberList.add(accountList.get(i).getAccountNumber() + "");
        }
        System.out.println("BLOCK: 25 "
                           + "(generateValidAccountsList post for loop)");

        return writeToFile(fileName, accountNumberList);
    }

    /**
    * Helper function that writes an arraylist of strings to file.
    * If the write fails the program ends.
    * @param fileName name of file to create
    * @param lines    desired file contents.
    * @return true if the write was successful
    */
    private static Boolean writeToFile(String fileName,
                                       ArrayList<String> lines) {
        System.out.println("BLOCK: 26 (writeToFile)");
        Path file = Paths.get(fileName);

        try {
                System.out.println("BLOCK: 27 (writeToFile try)");
			    Files.write(file, lines, Charset.forName("UTF-8"));
		    } catch (IOException e) {
                System.out.println("BLOCK: 28 (writeToFile catch)");
		        System.out.println("ERROR: Unable to write to file "
                                   + fileName
                                   + ".");
            System.exit(1);
		    }
        System.out.println("BLOCK: 29 (writeToFile post try)");
        return true;
    }

    /**
    * Helper function that splits a line by spaces.
    * @param line the line to separate
    * @return the split line
    */
    private static String[] parseLine(String line){
        System.out.println("BLOCK: 30 (parseLine)");
        return line.split(" ");
    }

    /**
    * Function to set the value of an account number in the hashmap.
    * @param accountNumber the number of the account to change
    * @param account the new account to store at this location in the hashmap
    */
    public static void setAccount(String accountNumber, Account account) {
        System.out.println("BLOCK: 31 (setAccount)");
        accounts.put(accountNumber, account);
    }

    /**
    * Function to get the Account stored at a specific entry in the hashmap
    * @param accountNumber the number of the account to retrieve
    * @return account stored at specified account number, or null if account does not exists
    */
    public static Account getAccount(String accountNumber) {
        System.out.println("BLOCK: 32 (getAccount)");
        return accounts.get(accountNumber);
    }

    /**
    * Function to remove an account from the hashmap.
    * If account does not exist it simply makes no changes.
    * @param accountNumber number of account to remove
    */
    public static void deleteAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }
}
