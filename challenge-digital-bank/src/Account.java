// uma classe abstrata é interessante para que não seja possível instanciar essa classe diretamente
// só as classes que estendem ela
public abstract class Account {

    private static final int AGENCY = 1;
    private static int SEQUENCIAL = 1;

    // protected deixa acessível pelas classes que estendem essa
    protected int agency;
    protected int number;
    protected double balance;
    protected Customer customer;

    public Account(Customer customer) {
        this.agency = Account.AGENCY;
        this.number = SEQUENCIAL++;
        this.customer = customer;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void transfer(Account recipientAccount, double amount) {
        this.withdraw(amount);
        recipientAccount.deposit(amount);
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public void printAccountData() {
        System.out.println(String.format("Nome: %s", this.customer.getName()));
        System.out.println(String.format("Cpf: %s", this.customer.getCpf()));
        System.out.println(String.format("Agência: %d", this.agency));
        System.out.println(String.format("Número: %d", this.number));
        System.out.println(String.format("Saldo: R$%.2f", this.balance));
    }

}
