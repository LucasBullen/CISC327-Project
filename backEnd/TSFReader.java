import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TSFReader {
    private String name;
    private BufferedReader br;

    public TSFReader(String name) {
        this.name = name;
        try{
            this.br = new BufferedReader(new FileReader(this.name));
        }
        catch(FileNotFoundException ex){
            System.out.println(name+" is not a file.");
            System.exit(0);
        }
    }

    public Transaction nextTransaction() {
        String line;
        try{
            line = this.br.readLine();
        }
        catch(IOException ex){
            return null;
        }
        String type = line.substring(0,2);

        if (type.equals("CR")) {
            return new CreateTransaction(line);
        } else if (type.equals("DE")) {
            return new DeleteTransaction(line);
        } else if (type.equals("WD")) {
            return new WithdrawTransaction(line);
        } else if (type.equals("TR")) {
            return new TransactionTransaction(line);
        } else if (type.equals("ES")) {
            return null;
        }
        return null;
    }
}
