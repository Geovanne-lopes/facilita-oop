import java.util.Scanner;

public class Login {

    private String username;
    private String password;
    Scanner sc = new Scanner(System.in);
    Printers printers = new Printers();

    public Login() {
        cadastro();
        realizarLogin();
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void cadastro() {
        printers.printer(Textos.INICIO_CADASTRO);
        printers.printer(Textos.TEXT_USERNAME);
        username = sc.nextLine();
        printers.printer(Textos.TEXT_PASSWORD);
        password = sc.nextLine();
        printers.printer(Textos.CADASTRO_REALIZADO + username + Textos.COM_SUCESSO);
    }

    public void realizarLogin () {

        int tentativas = 0;
        boolean logado = false;

        while (tentativas < 3 && !logado) {
            printers.printer(Textos.INICIAR_LOGIN);
            printers.printer(Textos.USERNAME);
            String loginDigitado = sc.nextLine();
            printers.printer(Textos.PASSWORD);
            String senhaDigitada = sc.nextLine();
            if (loginDigitado.equals(username) && senhaDigitada.equals(password)) {
                printers.printer(Textos.LOGIN_REALIZADO);
                logado = true;
            } else {
                tentativas++;
                printers.printer(Textos.ERRO_LOGIN + + tentativas + Textos.ERRO_CONTADOR);
            }
        }

        if (!logado) {
            printers.printer(Textos.EXCEDENTE_TENTATIVA);
            System.exit(0);
        }
    }
}