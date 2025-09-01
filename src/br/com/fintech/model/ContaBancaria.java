package br.com.fintech.model;

import java.util.Scanner;

public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    Scanner sc = new Scanner(System.in);
    Printers printers = new Printers();

    public ContaBancaria() {
    }

    public void cadastrarDadosConta() {
        printers.printer(Textos.NUMERO_CONTA);
        this.numeroConta = sc.nextLine();
        printers.printer(Textos.SALDO_INICIAL);
        this.saldo = sc.nextDouble();
        sc.nextLine();
    }

    public void depositar() {
        printers.printer(Textos.VALOR_DEPOSITO);
        double valorDeposito = sc.nextDouble();
        sc.nextLine();
        Transacao deposito = new Transacao(
                "DEPÓSITO",
                valorDeposito,
                getNumeroConta()
        );
        deposito.executarTransacao();
        if (valorDeposito > 0) {
            this.saldo += valorDeposito;
            printers.printer(Textos.DEPOSITO_DE + valorDeposito + Textos.COM_SUCESSO);
        } else {
            printers.printer(Textos.DEPOSITO_INVALIDO);
        }
    }

    public void sacar() {
        printers.printer(Textos.VALOR_SAQUE);
        double valorSaque = sc.nextDouble();
        sc.nextLine();
        Transacao saque = new Transacao(
                "SAQUE",
                valorSaque,
                getNumeroConta()
        );
        saque.executarTransacao();
        if (valorSaque > 0) {
            if (valorSaque <= saldo) {
                this.saldo -= valorSaque;
                printers.printer(Textos.SAQUE_DE + valorSaque + Textos.COM_SUCESSO);
            } else {
                printers.printer(Textos.SAQUE_INVALIDO);
            }
        } else {
            printers.printer(Textos.SAQUE_INVALIDO);
        }
    }

    public void consultarSaldo() {
        printers.printer(Textos.SALDO_CONTA + numeroConta + Textos.RS + saldo);
    }

    public void transferir() {
        printers.printer(Textos.CONTA_DESTINO);
        String contaDestino = sc.nextLine();
        printers.printer(Textos.VALOR_TRANSFERENCIA);
        double valorTransferencia = sc.nextDouble();
        sc.nextLine();

        Transacao transferencia = new Transacao(
                "TRANSFERÊNCIA",
                valorTransferencia,
                contaDestino
        );
        transferencia.executarTransacao();
        if (valorTransferencia > 0) {
            if (valorTransferencia <= saldo) {
                this.saldo -= valorTransferencia;
                printers.printer(Textos.TRANSFERENCIA_DE + valorTransferencia + Textos.PARA_CONTA + contaDestino + Textos.COM_SUCESSO_FEMININO);
            } else {
                printers.printer(Textos.TRANSFERENCIA_INSUFICIENTE);
            }
        } else {
            printers.printer(Textos.TRANSFERENCIA_INVALIDA);
        }
    }

    public void exibirExtrato() {
        printers.printer(Textos.EXTRATO_BANCARIO);
        printers.printer(Textos.TITULAR + getTitular());
        printers.printer(Textos.CONTA + getNumeroConta());
        printers.printer(Textos.SALDO_ATUAL + getSaldo());
    }


    public String getNumeroConta() { return numeroConta; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getSaldo() { return saldo; }
}