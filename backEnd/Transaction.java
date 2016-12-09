/**
* Abstract class that defines the behaviour of all transaction classes.
* Create, Delete, Deposit, Withdraw, Transfer transactions extend this class.
*/
import java.util.Arrays;
public abstract class Transaction {
    protected String type;
    protected String sourceAccount;
    protected String targetAccount;
    protected Integer amount;
    protected String sourceName;

    /**
    * Constructor
    * @param data the TSF line to parse in format "XX XXXXXXXX XXXXXXXX XXXX XXXX"
    */
    public Transaction(String data) {
        String[] tokens = data.split(" ");
        System.out.println("BACKEND TRANSACTION tokens:");
        System.out.println(Arrays.toString(tokens));
        this.type = tokens[0];
        this.sourceAccount = tokens[1];
        this.targetAccount = tokens[2];
        this.amount = Integer.parseInt(tokens[3]);
        this.sourceName = tokens[4];
        for(int i = 5; i<tokens.length; i++){
            this.sourceName = this.sourceName + " " + tokens[i];
        }
    }

    /**
    * Getter for transaction type (eg. CR, DL)
    * @return the 2-letter code for this transaction's type
    */
    public String getType() {
        return this.type;
    }

    /**
    * Getter for the source account for this transaction.
    * @return the 8-digit account number
    */
    public String getSourceAccount() {
        return this.sourceAccount;
    }

    /**
    * Getter for the destination/target account for this transaction.
    * @return the 8-digit account number
    */
    public String getTargetAccount() {
        return this.targetAccount;
    }

    /**
    * Getter for the amount of this transaction.
    * @return the amount of this transaction in cents.
    */
    public Integer getAmount() {
        return this.amount;
    }

    /**
    * Getter for the name of the source account for this transaction.
    * @return the name of the account
    */
    public String getSourceName() {
        return this.sourceName;
    }

    /**
    * Abstract apply method that is extended by each transaction type differently
    * @return true if the apply function succeeds
    */
    abstract Boolean apply();
}
