package br.com.fintech;

public class App {
    public static void main(String[] args) {
        Conta conta = new Conta("002", "Bruno Lima");
        conta.depositar(250);

        try {
            System.out.println("Tentando sacar R$ 5.000...");
            conta.sacar(5000);
            System.out.println("Saque realizado!");          // não executa
        } catch (SaldoInsuficienteException e) {
            System.out.println("Operação recusada: " + e.getMessage());
        } finally {
            System.out.println("Saldo após a tentativa: R$ " + conta.getSaldo());
        }

        try {
            conta.depositar(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Depósito inválido: " + e.getMessage());
        }

        System.out.println("O programa continua normalmente.");
    }
}
