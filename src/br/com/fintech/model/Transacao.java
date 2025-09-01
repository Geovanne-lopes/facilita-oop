package br.com.fintech.model;

public class Transacao {
    private final String tipo;
    private final double valor;
    private final String contaRelacionada;

    Printers printers = new Printers();

    public Transacao(String tipo, double valor, String contaRelacionada) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaRelacionada = contaRelacionada;
    }

    public void executarTransacao() {
        printers.printer(Textos.EXECUTANDO_TRANSACAO + tipo + Textos.VALOR_TRANSACAO + valor);
    }
}