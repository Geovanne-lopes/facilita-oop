import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final DadosUsuario dadosUsuario = new DadosUsuario();

    Printers printers = new Printers();

    public Menu() {
        exibirMenu();
    }

    public void exibirMenu() {
        int opcao;

        printers.printer(Textos.CADASTRO_DADOS);
        dadosUsuario.inserirDados();

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
                case 0:
                    printers.printer(Textos.SAINDO_PROGRAMA);
                    break;
                default:
                    printers.printer(Textos.OPCAO_INVALIDA);
                    break;
            }
        } while (opcao != 0);
    }

}
