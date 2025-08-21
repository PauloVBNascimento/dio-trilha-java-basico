import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bem-vindo ao Cadastro do Banco.");

        int numero;
        String agencia;
        String nome;
        double saldo;

        while (true) {

            System.out.println("\nPor favor, digite o número da conta: (até 7 números)");
            if (!scanner.hasNextInt()) {
                System.out.println("Número Inválido!\nA sua conta deve ter apenas números. Tente novamente!");
                scanner.nextLine();
                continue;
            }

            numero = scanner.nextInt();
            scanner.nextLine();

            if (numero <= 0) {
                System.out.println("Número Inválido!\nO número da conta deve ser maior que 0. Tente novamente!");
            } else if (String.valueOf(numero).length() >= 7) {
                System.out.println(
                        "Número Inválido!\nO número da sua conta deve ter no máximo 7 números. Tente novamente!");
            } else {
                break;
            }

        }

        while (true) {
            System.out.println("\nPor favor digite a sua agência:  (exatamente 4 números)");
            agencia = scanner.nextLine();
            if (agencia.matches("\\d{4}")) {
                agencia = agencia.substring(0, 3) + "-" + agencia.charAt(3);
                break;
            } else {
                System.out.println(
                        "Agencia Inválida!\nSua conta deve ter apenas 4 números exatos (ex: 1234). Tente novamente!");
            }

        }

        while (true) {
            System.out.println("\nPor favor, digite o seu nome: (apenas letras)");
            nome = scanner.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Nome Inválido!\nO nome não pode ser vazio. Tente novamente!");
            } else if (!nome.matches("[A-Za-zÀ-ÿ ]+")) {
                System.out.println("Nome Inválido!\nO nome deve ter apenas letras e espaços. Tente novamente!");
            } else if (nome.length() < 3) {
                System.out.println("Nome Inválido!\nO nome deve ter no mínimo 3 caracteres. Tente novamente!");
            } else {
                nome = nome.toUpperCase();
                break;
            }
        }

        while (true) {
            System.out.println("\nPor favor, digite o seu saldo: (apenas números)");
            if (scanner.hasNextDouble()) {
                saldo = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out
                        .println("Saldo inválido!\nO saldo deve ser um número decimal (Ex: 123.25). Tente novamente!");
                scanner.nextLine();
            }
        }
        scanner.close();

        System.out.printf("Olá  %s, obrigado por criar uma conta em nosso banco, sua agência é %s conta %d e seu saldo de %.2f R$ já está disponível para saque.",
        nome, agencia, numero, saldo
        );
    }
}
