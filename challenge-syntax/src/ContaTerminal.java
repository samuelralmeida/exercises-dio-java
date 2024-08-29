import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Por favor, digite a agência: ");
        String branch = scanner.nextLine();

        System.out.print("Por favor, digite o número da conta: ");
        int account = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Por favor, digite o nome do cliente: ");
        String customer = scanner.nextLine();

        System.out.print("Por favor, digite o saldo da conta: ");
        double balance = scanner.nextDouble();

        String resp = "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque";
        resp = String.format(resp, customer, branch, account, balance);

        System.out.println(resp);

        scanner.close();
    }
}
