public class MainAccount extends Account {

    public MainAccount(Customer customer) {
        super(customer);
    }

    public void printStatement() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.printAccountData();
        System.out.println("");
    }
}
