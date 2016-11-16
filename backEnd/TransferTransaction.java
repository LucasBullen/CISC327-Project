/**
* Class representing a transfer transaction.
* The apply() method attempts to subtract a balance from the source account
* and give it to the destination account.
*/
public class TransferTransaction extends Transaction {
    /**
    * Constructor.
    * @param data the line from the TSF of the form "TR XXXXXXXX XXXXXXXX XXXX ***"
    */
    public TransferTransaction(String data) {
        super(data);
    }

    /**
    * Function that attempts to subtract the balance from the source account
    * and add it to the target account.
    * @return true if the transfer was successful.
    */
    public Boolean apply() {
        Account transferFrom = MAF.getAccount(this.sourceAccount);
        Account transferTo = MAF.getAccount(this.targetAccount);

        if (transferFrom == null) {
            System.out.println("transfer failed: source account does not exist");
            return false;
        } else if (transferTo == null) {
            System.out.println("transfer failed: target account does not exist");
            return false;
        } else if (transferFrom.getAccountBalance() < this.amount) {
            System.out.println("transfer failed: source account balance insufficient");
            return false;
        } else if (transferTo.getAccountBalance() + this.amount > 99999999) {
            System.out.println("transfer failed: target account balance maximum exceeded");
            return false;
        } else {
            transferFrom.setAccountBalance(transferFrom.getAccountBalance() - this.amount);
            transferTo.setAccountBalance(transferTo.getAccountBalance() + this.amount);
            MAF.setAccount(this.sourceAccount, transferFrom);
            MAF.setAccount(this.targetAccount, transferTo);
            return true;
        }
    }
}
