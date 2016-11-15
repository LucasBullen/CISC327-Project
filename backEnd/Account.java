public class Account {
    private String accountNumber;
    private String accountName;
    private Integer accountBalance;

    public Account(String accountNumber, String accountName, Integer accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public Integer getAccountBalance() {
        return this.accountBalance;
    }
}
