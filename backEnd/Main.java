private class Main {

    public static void main(String[] args) {
        Transaction transaction = new Transaction("CR 11111111 00000000 000 GRANT");
        
        System.out.println(getType());
        System.out.println(getSourceAccount());
        System.out.println(getTargetAccount());
        System.out.println(getAmount());
        System.out.println(getSourceName());
    }
}
