public abstract class Transaction {
    protected String type;
    protected String sourceAccount;
    protected String targetAccount;
    protected Integer amount;
    protected String sourceName;

    public Transaction(String data) {
        String[] tokens = data.split(" ");
        this.type = tokens[0];
        this.sourceAccount = tokens[1];
        this.targetAccount = tokens[2];
        this.amount = Integer.parseInt(tokens[3]);
        this.sourceName = tokens[4];
    }

    public String getType() {
        return this.type;
    }

    public String getSourceAccount() {
        return this.sourceAccount;
    }

    public String getTargetAccount() {
        return this.targetAccount;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public Boolean apply() {
        return false;
    }
}
