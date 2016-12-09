import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
* This class is responsible for reading in a TSF file.
* It supplies the next line of the TSF file when prompted with nextTransaction()
*/
public class TSFReader {
    private String name;
    private BufferedReader br;

    /**
    * Constructor opens the file and prepares to start reading it line by line
    * @param name the name of the file to open
    */
    public TSFReader(String name) {
        this.name = name;
        try{
            this.br = new BufferedReader(new FileReader(this.name));
        }
        catch(FileNotFoundException ex){
            System.out.println("ERROR: " + name + " is not a file.");
            System.exit(1);
        }
    }

    /**
    * This function reads the next line of the loaded file and turns it into a
    * Transaction by parsing it.
    * @return the parsed line as a Transaction.
    */
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
        } else if (type.equals("DL")) {
            return new DeleteTransaction(line);
        } else if (type.equals("DE")) {
            return new DepositTransaction(line);
        } else if (type.equals("WD")) {
            return new WithdrawTransaction(line);
        } else if (type.equals("TR")) {
            return new TransferTransaction(line);
        } else if (type.equals("ES")) {
            return null;
        }
        return null;
    }
}
