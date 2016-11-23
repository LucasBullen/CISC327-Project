/**
* This class represents a single bank account.
* The relevant information is an account number, an account name, and an
* account balance. The balance is stored as an integer because mathematical
* operations are ocassionally performed on it, but the account number remains
* a string.
*/
public class Account {
    private String accountNumber;
    private String accountName;
    private Integer accountBalance;

    /**
    * Constructor for an Account
    * @param accountNumber  the 8-digit ID number of the account
    * @param accountName    the name of the account holder
    * @param accountBalance the number of cents in the account
    */
    public Account(String accountNumber,
                   String accountName,
                   Integer accountBalance) {
        System.out.println("BLOCK: 6 (account constructor)");
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    /**
    * Getter for account number
    * @return the account number
    */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
    * Getter for account name
    * @return the account name
    */
    public String getAccountName() {
        return this.accountName;
    }

    /**
    * Getter for the account balance
    * @return the account balance
    */
    public Integer getAccountBalance() {
        return this.accountBalance;
    }

    /**
    * Setter for the account balance.
    * @param balance sets the account's balance to new value balance
    */
    public void setAccountBalance(Integer balance) {
        this.accountBalance = balance;
    }
}
