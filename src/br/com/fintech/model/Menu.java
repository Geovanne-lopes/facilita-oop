package br.com.fintech.model;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final DadosUsuario dadosUsuario = new DadosUsuario();
    private final ContaBancaria contaBancaria = new ContaBancaria();

    Printers printers = new Printers();

    public Menu() {
    }

    public void exibirMenu() {
        int opcao;

        printers.printer(Textos.BOAS_VINDAS);
        printers.printer(Textos.CADASTRO_DADOS);
        dadosUsuario.inserirDados();
        contaBancaria.cadastrarDadosConta();
        contaBancaria.setTitular(dadosUsuario.getNome() + " " + dadosUsuario.getSobrenome());

        do {
            printers.printer(Textos.MENU_CADASTRO);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    dadosUsuario.exibirInformacoes();
                    break;
                case 2:
                    dadosUsuario.editarDados();
                    break;
                case 3:
                    exibirMenuConta();
                    break;
                case 0:
                    printers.printer(Textos.SAINDO_PROGRAMA);
                    break;
                default:
                    printers.printer(Textos.OPCAO_INVALIDA);
                    break;
            }
        } while (opcao != 0);
        sc.close();

    }


    public void exibirMenuConta() {
        int opcao;
        do {
            printers.printer(Textos.MENU_CONTA_BANCARIA);

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    contaBancaria.consultarSaldo();
                    break;
                case 2:
                    contaBancaria.depositar();
                    break;
                case 3:
                    contaBancaria.sacar();
                    break;
                case 4:
                    contaBancaria.transferir();
                    break;
                case 5:
                    contaBancaria.exibirExtrato();
                    break;
                case 0:
                    break;
                default:
                    printers.printer(Textos.OPCAO_INVALIDA);
            }
        } while (opcao != 0);
    }
}