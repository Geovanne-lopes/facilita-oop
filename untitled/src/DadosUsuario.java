import java.util.Scanner;

public class DadosUsuario {

    Scanner sc = new Scanner(System.in);

    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    Printers printers = new Printers();

    public boolean validarEmailRegex() {
        return email != null && email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    public boolean validarCPF() {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public DadosUsuario() {

    }
    public DadosUsuario(String nome, String sobrenome, String email, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
    }

    public void inserirDados() {
        printers.printer(Textos.TEXT_NOME);
        nome = sc.nextLine();
        printers.printer(Textos.TEXT_SOBRENOME);
        sobrenome = sc.nextLine();

        do {
            printers.printer(Textos.TEXT_EMAIL);
            email = sc.nextLine();

            if  (!validarEmailRegex()) {
                printers.printer(Textos.TEXT_ERRO_EMAIL);
            }
        } while (!validarEmailRegex());

        do {
            printers.printer(Textos.TEXT_CPF);
            cpf = sc.nextLine();

            if (!validarCPF()) {
                printers.printer(Textos.TEXT_ERRO_CPF);
            }
        } while (!validarCPF());

        printers.printer(Textos.SUCESSO_CADASTRO);

    }

    public void setNome(String nome) {this.nome = nome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public void setEmail(String email) {this.email = email;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public void exibirInformacoes() {
        printers.printer(Textos.PRINT_NOME + nome);
        printers.printer(Textos.PRINT_SOBRENOME + sobrenome);
        printers.printer(Textos.PRINT_EMAIL + email);
        printers.printer(Textos.PRINT_CPF + cpf);
    }

    public void editarDados() {
        int opcao;
        do {
            printers.printer(Textos.MENU_EDITAR_DADOS);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    printers.printer(Textos.NOVO_NOME);
                    nome = sc.nextLine();
                    break;
                case 2:
                    printers.printer(Textos.NOVO_SOBRENOME);
                    sobrenome = sc.nextLine();
                    break;
                case 3:
                    do {
                        printers.printer(Textos.NOVO_EMAIL);
                        email = sc.nextLine();

                        if (!validarEmailRegex()) {
                            printers.printer(Textos.TEXT_ERRO_EMAIL);
                        }
                    } while (!validarEmailRegex());
                    break;
                case 0:
                    printers.printer(Textos.NENHUM_DADO);
                    break;
                default:
                    printers.printer(Textos.OPCAO_INVALIDA);
                    break;
            }
        } while (opcao != 0);
    }
}


