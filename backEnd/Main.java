public class Main {

    public static void main(String[] args) {
        Transaction transaction = new Transaction("CR 11111111 00000000 000 GRANT");

        System.out.println(transaction.getType());
        System.out.println(transaction.getSourceAccount());
        System.out.println(transaction.getTargetAccount());
        System.out.println(transaction.getAmount());
        System.out.println(transaction.getSourceName());

        Account account = new Account("aifnoa", "ajbdf", 1478);

        System.out.println(account.getAccountNumber());
        System.out.println(account.getAccountName());
        System.out.println(account.getAccountBalance());
    }
}
