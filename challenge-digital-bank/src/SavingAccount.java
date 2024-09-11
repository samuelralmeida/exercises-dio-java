public class SavingAccount extends Account {

    public SavingAccount(Customer customer) {
        super(customer);
    }

    public void printStatement() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.printAccountData();
        System.out.println("");
    }
}
