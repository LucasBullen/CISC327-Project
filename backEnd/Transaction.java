public class Transaction {
    private String type;
    private String sourceAccount;
    private String targetAccount;
    private Integer amount;
    private String sourceName;

    public Transaction(String data) {
        String[] tokens = data.split(" ");
        this.type = tokens[0];
        this.sourceAccount = token[1];
        this.targetAccount = token[2];
        this.amount = Integer.parseInt(token[3]);
        this.sourceName = token[4];
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
}
