public class DepositTransaction extends Transaction {
    public DepositTransaction(String data) {
        super(data);
    }

    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null) {
            System.out.println("deposit failed");
            return false;
        } else {
            account.setAccountBalance(account.getAccountBalance() + this.amount);
            MAF.setAccount(this.sourceAccount, account);
            return true;
        }
    }
}
