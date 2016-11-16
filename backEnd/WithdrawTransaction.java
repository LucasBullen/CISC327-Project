public class WithdrawTransaction extends Transaction {
    public WithdrawTransaction(String data) {
        super(data);
    }

    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null) {
            System.out.println("withdraw failed");
            return false;
        }else if(account.getAccountBalance() - this.amount < 0) {
            System.out.println("withdraw failed");
            return false;
        }else {
            account.setAccountBalance(account.getAccountBalance() - this.amount);
            MAF.setAccount(this.sourceAccount, account);
            return true;
        }
    }
}
