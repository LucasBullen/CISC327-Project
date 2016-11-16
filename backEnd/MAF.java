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

public final class MAF {
    private static Map<String, Account> accounts;
    private static BufferedReader br;

    private MAF() { }

    public static Boolean load(String fileName) {
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch(IOException e) {
            System.out.println("Error: " + e);
            return false;
        }
        accounts = new HashMap<String, Account>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      		stream.forEach(line -> {
                String[] parse = parseLine(line);
                Account account = new Account(parse[0], parse[2], Integer.parseInt(parse[1]));
                accounts.put(parse[0], account);
            });
		} catch(IOException e) {
			System.out.println("Error: " + e);
			return false;
		}

		return true;
    }

    public static void generateMasterAccountsList(String fileName) {
        ArrayList<Account> accountList = new ArrayList<Account>(accounts.values());
        ArrayList<String> accountNumberList = new ArrayList<String>();

        for (int i = 0; i < accountList.size(); i++) {
            accountNumberList.add(accountList.get(i).getAccountNumber() + " " +
                                  accountList.get(i).getAccountBalance()  + " " +
                                  accountList.get(i).getAccountName());
        }

        Collections.sort(accountNumberList);

        writeToFile(fileName, accountNumberList);
    }

    public static void generateValidAccountsList(String fileName) {
        ArrayList<Account> accountList = new ArrayList<Account>(accounts.values());
        ArrayList<String> accountNumberList = new ArrayList<String>();

        for (int i = 0; i < accountList.size(); i++) {
            accountNumberList.add(accountList.get(i).getAccountNumber() + "");
        }

        writeToFile(fileName, accountNumberList);
    }

    private static void writeToFile(String fileName, ArrayList<String> lines){
        Path file = Paths.get(fileName);

        try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
    }

    private static String[] parseLine(String line){
        return line.split(" ");
    }

    public static void setAccount(String accountNumber, Account account) {
        accounts.put(accountNumber, account);
    }

    public static Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public static void deleteAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }
}
