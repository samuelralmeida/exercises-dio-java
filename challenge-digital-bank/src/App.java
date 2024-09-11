public class App {
    public static void main(String[] args) throws Exception {
        Customer customerA = new Customer("customerA", "18872644983");
        Customer customerB = new Customer("customerB", "19872644759");

        MainAccount cc = new MainAccount(customerA);
        SavingAccount cp = new SavingAccount(customerB);

        cc.deposit(100);
        cc.transfer(cp, 55);

        cc.printStatement();
        cp.printStatement();

    }
}
