public class CreateTransaction extends Transaction {
    public CreateTransaction(String data) {
        super(data);
    }

    public Boolean apply() {
         if (MAF.getAccount(this.sourceAccount) == null) {
             Account account = new Account(this.sourceAccount, this.sourceName, 0);
             MAF.setAccount(this.sourceAccount, account);
             return true;
         } else {
             return false;
         }
    }
}
