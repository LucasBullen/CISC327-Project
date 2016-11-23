/**
* This class represents the create transaction type.
* Its apply() function adds an account to the MAF.
*/
public class CreateTransaction extends Transaction {
    /**
    * Constructor.
    * @param data the line from a TSF in the form "CR XXXXXXXX 00000000 000 XXXX"
    */
    public CreateTransaction(String data) {
        System.out.println("BLOCK: 7 (CreateTransaction constructor)");
        super(data);
    }

    /**
    * Function that attempts to create the new account in the Masters Account list
    * @return true if account number was not already in use
    */
    public Boolean apply() {
        System.out.println("BLOCK: 8 (CreateTransaction apply)");
        if (MAF.getAccount(this.sourceAccount) == null) {
            System.out.println("BLOCK: 9 (CreateTransaction, if)");
            Account account = new Account(this.sourceAccount,
                                          this.sourceName,
                                          0);
            MAF.setAccount(this.sourceAccount, account);
            return true;
        } else {
            System.out.println("BLOCK: 10 (CreateTransaction, else)");
            System.out.println("create failed: account number already exists");
            return false;
        }
    }
}
