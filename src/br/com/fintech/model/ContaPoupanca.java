package br.com.fintech.model;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    private Scanner sc = new Scanner(System.in);
    private Printers printers = new Printers();

    public ContaPoupanca() {
        setTypeConta("Conta Poupança");
    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public void cadastrarDadosConta() {
        printers.printer(Textos.NUMERO_CONTA);
        setNumeroConta(sc.nextLine());
        printers.printer(Textos.SALDO_INICIAL);
        setSaldo(sc.nextDouble());
        sc.nextLine();
    }

    @Override
    public void depositar() {
        printers.printer(Textos.VALOR_DEPOSITO);
        double valor = sc.nextDouble();
        sc.nextLine();

        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            printers.printer(Textos.DEPOSITO_DE + valor + Textos.COM_SUCESSO);
        } else {
            printers.printer(Textos.DEPOSITO_INVALIDO);
        }

        new Transacao("DEPÓSITO", valor, getNumeroConta()).executarTransacao();
    }

    @Override
    public void sacar() {
        printers.printer(Textos.VALOR_SAQUE);
        double valor = sc.nextDouble();
        sc.nextLine();

        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            printers.printer(Textos.SAQUE_DE + valor + Textos.COM_SUCESSO);
        } else {
            printers.printer(Textos.SAQUE_INVALIDO);
        }

        new Transacao("SAQUE", valor, getNumeroConta()).executarTransacao();
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

    }

    @Override
    public void transferir() {
        printers.printer(Textos.CONTA_DESTINO);
        String destino = sc.nextLine();
        printers.printer(Textos.VALOR_TRANSFERENCIA);
        double valor = sc.nextDouble();
        sc.nextLine();

        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            printers.printer(Textos.TRANSFERENCIA_DE + valor + Textos.PARA_CONTA + destino + Textos.COM_SUCESSO_FEMININO);
        } else {
            printers.printer(Textos.TRANSFERENCIA_INVALIDA);
        }

        new Transacao("TRANSFERÊNCIA", valor, destino).executarTransacao();
    }

    @Override
    public void consultarSaldo() {
        printers.printer(Textos.SALDO_CONTA + getNumeroConta() + Textos.RS + getSaldo());
    }

    @Override
    public void exibirExtrato() {
        printers.printer(Textos.EXTRATO_BANCARIO);
        printers.printer(Textos.TITULAR + getTitular());
        printers.printer(Textos.CONTA + getNumeroConta());
        printers.printer(Textos.TIPO_CONTA + getTypeConta());
        printers.printer(Textos.SALDO_ATUAL + getSaldo());
    }
}
