public class Main {

    public static void main(String[] args) {
        // Transaction transaction = new Transaction("CR 11111111 00000000 000 GRANT");
        //
        // System.out.println(transaction.getType());
        // System.out.println(transaction.getSourceAccount());
        // System.out.println(transaction.getTargetAccount());
        // System.out.println(transaction.getAmount());
        // System.out.println(transaction.getSourceName());

        Account account = new Account("aifnoa", "ajbdf", 1478);

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        MAF.load("MAF.txt");
        account = MAF.getAccount("11111111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        account = MAF.getAccount("11163111");
        System.out.println(account);

        System.out.println("Create");
        Transaction transaction = new CreateTransaction("CR 11163111 00000000 000 GRANT");
        transaction.apply();

        account = MAF.getAccount("11163111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        transaction = new CreateTransaction("CR 11113111 00000000 000 DAN");
        transaction.apply();

        account = MAF.getAccount("11113111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        System.out.println("Deposit:");

        account = MAF.getAccount("11163111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        transaction = new DepositTransaction("DE 11163111 00000000 111 ***");
        transaction.apply();

        transaction = new DepositTransaction("DE 11163111 00000000 222 ***");
        transaction.apply();

        account = MAF.getAccount("11163111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        System.out.println("transfer");

        transaction = new TransferTransaction("TR 11163111 11113111 333 ***");
        transaction.apply();

        account = MAF.getAccount("11163111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        account = MAF.getAccount("11113111");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());

        System.out.println("Delete:");
        transaction = new DeleteTransaction("DL 11163111 00000000 000 GRANT");
        transaction.apply();

        account = MAF.getAccount("11163111");
        System.out.println(account);

        MAF.generateValidAccountList("ValidAccountsList.txt");
        MAF.sortAccounts("MasterAccountsList");
    }
}
