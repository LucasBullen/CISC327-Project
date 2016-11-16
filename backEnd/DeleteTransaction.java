public class DeleteTransaction extends Transaction {
    public DeleteTransaction(String data) {
        super(data);
    }

    public Boolean apply() {
        Account account = MAF.getAccount(this.sourceAccount);
        if (account == null || !account.getAccountName().equals(this.sourceName)) {
            System.out.println("delete failed");
            return false;
        } else {
            MAF.deleteAccount(account.getAccountNumber());
            return true;
        }
    }
}
