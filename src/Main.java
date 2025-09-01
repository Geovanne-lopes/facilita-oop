public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        Menu menu = new Menu();

        login.cadastro();
        login.realizarLogin();

        menu.exibirMenu();

    }
}