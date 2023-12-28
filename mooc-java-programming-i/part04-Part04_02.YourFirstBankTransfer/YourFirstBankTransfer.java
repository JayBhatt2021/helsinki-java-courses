public class YourFirstBankTransfer {
    public static void main(String[] args) {
        // Do not touch the code in Account.java
        // write your program here
        Account mA = new Account("Matthews account", 1000);
        Account myA = new Account("My account", 0);

        mA.withdrawal(100);
        myA.deposit(100);
        System.out.println(mA);
        System.out.println(myA);
    }
}
