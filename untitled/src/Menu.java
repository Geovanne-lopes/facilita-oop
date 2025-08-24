import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final DadosUsuario dadosUsuario = new DadosUsuario();

    public Menu() {
        exibirMenu();
    }

    public void exibirMenu() {
        int opcao;

        System.out.println("Vamos começar com o cadastro de seus dados!");
        dadosUsuario.inserirDados();

        do {
            System.out.println("Escolha uma opção: \n" +
                    "1- Exibir dados do Usuário\n" +
                    "2- Editar dados do Usuário\n" +
                    "0- Sair do programa");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    dadosUsuario.exibirInformacoes();
                    break;
                case 2:
                    dadosUsuario.editarDados();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso programa!");
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

}
