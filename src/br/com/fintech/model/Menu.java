package br.com.fintech.model;

import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final DadosUsuario dadosUsuario = new DadosUsuario();
    private Conta contaBancaria; // Polimorfismo: pode ser ContaCorrente ou ContaPoupanca
    private final Printers printers = new Printers();

    public void exibirMenu() {
        printers.printer(Textos.BOAS_VINDAS);
        printers.printer(Textos.CADASTRO_DADOS);
        dadosUsuario.inserirDados();

        // Escolher tipo de conta
        printers.printer("Escolha o tipo de conta: 1 - Conta Corrente, 2 - Conta Poupança");
        int tipoConta = sc.nextInt();
        sc.nextLine();

        if (tipoConta == 1) contaBancaria = new ContaCorrente();
        else contaBancaria = new ContaPoupanca();

        contaBancaria.cadastrarDadosConta();
        contaBancaria.setTitular(dadosUsuario.getNome() + " " + dadosUsuario.getSobrenome());

        int opcao;
        do {
            printers.printer(Textos.MENU_CADASTRO);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> dadosUsuario.exibirInformacoes();
                case 2 -> dadosUsuario.editarDados();
                case 3 -> exibirMenuConta();
                case 0 -> printers.printer(Textos.SAINDO_PROGRAMA);
                default -> printers.printer(Textos.OPCAO_INVALIDA);
            }
        } while (opcao != 0);
    }

    private void exibirMenuConta() {
        int opcao;
        do {
            printers.printer(Textos.MENU_CONTA_BANCARIA);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> contaBancaria.consultarSaldo();
                case 2 -> contaBancaria.depositar();
                case 3 -> contaBancaria.sacar();
                case 4 -> contaBancaria.transferir();
                case 5 -> contaBancaria.exibirExtrato();
                case 0 -> {} // Sai do menu
                default -> printers.printer(Textos.OPCAO_INVALIDA);
            }
        } while (opcao != 0);
    }
}
