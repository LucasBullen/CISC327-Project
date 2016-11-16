public class TransferTransaction extends Transaction {
    public TransferTransaction(String data) {
        super(data);
    }

    public Boolean apply() {
        Account transferFrom = MAF.getAccount(this.sourceAccount);
        Account transferTo = MAF.getAccount(this.targetAccount);

        if (transferFrom == null || transferTo == null || transferFrom.getAccountBalance() < this.amount) {
            System.out.println("transfer failed");
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
