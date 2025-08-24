import java.util.Scanner;

public class Login {

    private String username;
    private String password;
    Scanner sc = new Scanner(System.in);

    public Login() {
        cadastro();
        realizarLogin();
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void cadastro() {
        System.out.println("Vamos realizar seu cadastro.");
        System.out.print("Por favor, digite seu login: ");
        username = sc.nextLine();
        System.out.print("Por favor, digite sua senha: ");
        password = sc.nextLine();
        System.out.println("Cadastro do usuário: " + username + " realizado com sucesso!");
    }

    public void realizarLogin () {

        int tentativas = 0;
        boolean logado = false;

        while (tentativas < 3 && !logado) {
            System.out.println("Insira suas credenciais para realizar o login: ");
            System.out.print("Login: ");
            String loginDigitado = sc.nextLine();
            System.out.print("Senha: ");
            String senhaDigitada = sc.nextLine();
            if (loginDigitado.equals(username) && senhaDigitada.equals(password)) {
                System.out.println("✅ Login realizado com sucesso!");
                logado = true;
            } else {
                tentativas++;
                System.out.print("❌ Usuário ou senha inválidos. Tentativa " + tentativas + " de 3.");
            }
        }

        if (!logado) {
            System.out.println("\n⛔ Número máximo de tentativas atingido. Encerrando o programa...");
            System.exit(0);
        }
    }
}