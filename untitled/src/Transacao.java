import java.time.LocalDateTime;

public class Transacao {
    private final String idTransacao;
    private final String tipo;
    private final double valor;
    private final String contaRelacionada;
    private final String dataHora;

    Printers printers = new Printers();

    public Transacao(String idTransacao, String tipo, double valor, String contaRelacionada) {
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.contaRelacionada = contaRelacionada;
        this.dataHora = LocalDateTime.now().toString();
    }

    public void executarTransacao() {
        printers.printer(Textos.EXECUTANDO_TRANSACAO + tipo + Textos.VALOR_TRANSACAO + valor);
    }

//    public String getIdTransacao() {
//        return idTransacao;
//    }

//    public void cancelarTransacao() {
//        printers.printer(Textos.CANCELANDO_TRANSACAO + idTransacao);
//    }

//    public void consultarStatus() {
//        printers.printer(Textos.STATUS_TRANSACAO + idTransacao);
//    }


//    public String getIdTransacao() { return idTransacao; }
//    public void setIdTransacao(String idTransacao) { this.idTransacao = idTransacao; }
//    public String getTipo() { return tipo; }
//    public void setTipo(String tipo) { this.tipo = tipo; }
//    public double getValor() { return valor; }
//    public void setValor(double valor) { this.valor = valor; }
//    public String getContaRelacionada() { return contaRelacionada; }
//    public void setContaRelacionada(String contaRelacionada) { this.contaRelacionada = contaRelacionada; }
//    public String getDataHora() { return dataHora; }
//    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

//    public String getIdTransacao() {
//        return idTransacao;
//    }

//    public String getIdTransacao() {
//        return idTransacao;
//    }
}