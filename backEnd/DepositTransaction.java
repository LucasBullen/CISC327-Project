/**
* Class representing a delete transaction.
* The apply() method attempts to increase an account's balance in the MAF
*/
public class DepositTransaction extends Transaction {
    /**
    * Constructor
    * @param data the line from a TSF in the form "DE XXXXXXXX 00000000 XXXX ***"
    */
    public DepositTransaction(String data) {
        super(data);
    }

    /**
    * Function that attempts to increase the specified account's balance.
    * @return true if account exists and does not exceed maximum balance after deposit
    */
    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null) {
            System.out.println("deposit failed: account does not exist");
            return false;
        } else if(account.getAccountBalance() + this.amount > 99999999) {
            System.out.println("deposit failed: account balance maximum exceeded");
            return false;
        } else {
            account.setAccountBalance(account.getAccountBalance() + this.amount);
            MAF.setAccount(this.sourceAccount, account);
            return true;
        }
    }
}
