package br.com.fintech.main;


import br.com.fintech.dao.ContaDAO;
import br.com.fintech.model.Conta;
import br.com.fintech.model.ContaCorrente;
import java.util.List;

public class TesteDAO {

    public static void main(String[] args) {

        // Cria o DAO
        ContaDAO contaDAO = new ContaDAO();

        // Cria uma conta de exemplo
        Conta conta = new ContaCorrente("12345-6", "Maria Oliveira", 1500.00);
        conta.setTypeConta("Corrente");

        // Insere no banco
        System.out.println("Inserindo conta...");
        contaDAO.insert(conta);

        // Busca todas as contas no banco
        System.out.println("\nListando contas cadastradas:");
        List<Conta> contas = contaDAO.getAll();

        for (Conta c : contas) {
            System.out.println("Número: " + c.getNumeroConta());
            System.out.println("Titular: " + c.getTitular());
            System.out.println("Saldo: " + c.getSaldo());
            System.out.println("Tipo: " + c.getTypeConta());
            System.out.println("-------------------------");
        }

        System.out.println("Fim do teste!");
    }
}
