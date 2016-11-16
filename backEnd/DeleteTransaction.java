/**
* Class representing a delete transaction.
* The apply() function attempts to delete an account from the Masters Account List
*/
public class DeleteTransaction extends Transaction {
    /**
    * Constructor.
    * @param data the line from a TSF in the form "DL XXXXXXXX 00000000 000 XXXX"
    */
    public DeleteTransaction(String data) {
        super(data);
    }

    /**
    * Function that attempts to delete the account.
    * Requires that given name matches account number on file.
    * @return true if account existed before delete and name matched.
    */
    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null) {
            System.out.println("delete failed: account does not exist");
            return false;
        } else if (!account.getAccountName().equals(this.sourceName)) {
            System.out.println("delete failed: account name does not match");
            return false;
        } else {
            MAF.deleteAccount(account.getAccountNumber());
            return true;
        }
    }
}
