package br.com.fintech.model;

public abstract class Conta {
    private String numeroConta;
    private String titular;
    private double saldo;
    private String typeConta;

    public String getTypeConta() {
        return typeConta;
    }

    public void setTypeConta(String typeConta) {
        this.typeConta = typeConta;
    }

    public Conta() {}

    public Conta(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public double getSaldo() { return saldo; }
    protected void setSaldo(double saldo) { this.saldo = saldo; }

    // Métodos abstratos obrigatórios
    public abstract void depositar(double valor);
    public abstract void sacar();
    public abstract void transferir(double valor, Conta contaDestino);
    public abstract void exibirExtrato();

    public void cadastrarDadosConta() {
    }

    public void consultarSaldo() {
    }

    public void transferir() {
    }

    public abstract void depositar();
}
