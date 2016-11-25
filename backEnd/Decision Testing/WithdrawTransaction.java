/**
* This class represents a withdraw transaction.
* The apply() function attempts to subtract from the source account's balance.
*/
public class WithdrawTransaction extends Transaction {
    /**
    * Constructor.
    * @param data is the line from the TSF in the form "WD XXXXXXXX 00000000 XXXX ***"
    */
    public WithdrawTransaction(String data) {
        super(data);
    }

    /**
    * This function attempts to subtract from the source account's balance.
    * @return true if the withdraw is successul
    */
    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null) {
            System.out.println("accountNull");
            System.out.println("withdraw failed: account does not exist");
            return false;
        }else if(account.getAccountBalance() - this.amount < 0) {
            System.out.println("accountBalanceTooSmall");
            System.out.println("withdraw failed: account balance insufficient");
            return false;
        }else {
            System.out.println("otherwise");
            account.setAccountBalance(account.getAccountBalance() - this.amount);
            MAF.setAccount(this.sourceAccount, account);
            return true;
        }
    }
}
