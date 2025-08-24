import java.util.Scanner;

public class DadosUsuario {

    private String nome;

    private String sobrenome;

    private String email;

    private String cpf;

    Scanner sc = new Scanner(System.in);


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
        System.out.print("Digite o seu primeiro nome: ");
        nome = sc.nextLine();
        System.out.print("Digite o seu sobrenome: ");
        sobrenome = sc.nextLine();

        do {
            System.out.print("Digite o seu email: ");
            email = sc.nextLine();

            if  (!validarEmailRegex()) {
                System.out.println("⚠️ E-mail inválido. Digite novamente no formato correto (ex: usuario@dominio.com).");
            }
        } while (!validarEmailRegex());

        do {
            System.out.print("Digite o seu cpf, apenas números: ");
            cpf = sc.nextLine();

            if (!validarCPF()) {
                System.out.println("⚠️ CPF inválido. Digite novamente (somente números e com 11 dígitos).\"");
            }
        } while (!validarCPF());

        System.out.println("Dados cadastrados com sucesso! ");

    }

    public void setNome(String nome) {this.nome = nome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public void setEmail(String email) {this.email = email;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
    }

    public void editarDados() {
        int opcao;
        do {
            System.out.println("Digite qual dado você quer editar: \n" +
                    "1- Nome\n" +
                    "2- Sobrenome\n" +
                    "3- Email\n" +
                    "4- CPF\n" +
                    "0- Volar ao menu anterior");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    nome = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Digite o novo sobrenome: ");
                    sobrenome = sc.nextLine();
                    break;
                case 3:
                    do {
                        System.out.println("Digite o seu novo email: ");
                        email = sc.nextLine();

                        if (!validarEmailRegex()) {
                            System.out.println("⚠️ E-mail inválido. Digite novamente no formato correto (ex: usuario@dominio.com).");
                        }
                    } while (!validarEmailRegex());
                    break;
                case 4:
                    do {
                        System.out.println("Digite o seu cpf, apenas números: ");
                        cpf = sc.nextLine();

                        if (!validarCPF()) {
                            System.out.println("⚠️ CPF inválido. Digite novamente (somente números e com 11 dígitos).\"");
                        }
                    } while (!validarCPF());
                    break;
                case 0:
                    System.out.println("Nenhum dado foi editado!");
                    break;
                default:
                    System.out.println("Opção inválida! ");
                    break;
            }
        } while (opcao != 0);
    }
}


