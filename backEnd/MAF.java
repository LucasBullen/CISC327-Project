import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

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
