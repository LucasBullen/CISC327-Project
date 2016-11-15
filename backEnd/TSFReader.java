import java.io.BufferedReader;
import java.io.FileReader;

public class TSFReader {
    private String name;
    private BufferedReader br;

    public TSFReader(String name) {
        this.name = name;
        this.br = new BufferedReader(new FileReader(this.name));
    }

    public Transaction nextTransaction() {
        String line = this.br.readLine();
        String type = line.subString(0,2);

        if (type.equals("CR")) {
            
        } else if (type.equals("DE")) {

        } else if (type.equals("WD")) {

        } else if (type.equals("TR")) {

        } else if (type.equals("ES")) {

        }
    }
}
