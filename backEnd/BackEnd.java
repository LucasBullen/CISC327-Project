public class BackEnd {

    //java BackEnd MAF.txt TSF.txt MAF2.txt VAL.txt
    public static void main(String[] args) {
        if(args.length != 4){
            System.out.println("Incorrect parameters.");
            System.exit(0);
        }
        String old_MAF_name = args[0];
        String tsf_name = args[1];
        String new_MAF_name = args[2];
        String new_VAL_name = args[3];

        MAF.load(old_MAF_name);
        TSFReader tsf = new TSFReader(tsf_name);
        Transaction transaction = tsf.nextTransaction();
        while(transaction != null){
            transaction.apply();
            transaction = tsf.nextTransaction();
        }
        MAF.generateValidAccountsList(new_VAL_name);
        MAF.generateMasterAccountsList(new_MAF_name);
    }
}
