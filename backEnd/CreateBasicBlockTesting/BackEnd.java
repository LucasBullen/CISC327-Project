/**
* This class is the 'main' class responsible for taking in commandline
* arguments for the Masters Acccount File, Merged Transaction Summary File,
* New Masters Account File, and new Valid Accounts List file names
*/
public class BackEnd {
    /**
    * Callable from commandline with format java BackEnd MAF.txt TSF.txt MAF2.txt VAL.txt
    */
    public static void main(String[] args) {
        System.out.println("BLOCK: 1 (begin main)");
        if(args.length != 4){
            System.out.println("BLOCK: 2 (wrong args count)");
            System.out.println("Incorrect parameters.");
            System.exit(0);
        }
        System.out.println("BLOCK: 3 (main post if)");
        String old_MAF_name = args[0];
        String tsf_name = args[1];
        String new_MAF_name = args[2];
        String new_VAL_name = args[3];

        MAF.load(old_MAF_name);
        TSFReader tsf = new TSFReader(tsf_name);
        Transaction transaction = tsf.nextTransaction();
        while(transaction != null){
            System.out.println("BLOCK: 4 (main, in while)");
            transaction.apply();
            transaction = tsf.nextTransaction();
        }
        System.out.println("BLOCK: 5 (main, post while)");
        MAF.generateValidAccountsList(new_VAL_name);
        MAF.generateMasterAccountsList(new_MAF_name);
    }
}
