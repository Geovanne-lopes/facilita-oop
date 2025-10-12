package br.com.fintech.dao;


import br.com.fintech.model.Conta;
import br.com.fintech.model.ContaCorrente;
import java.sql.*;

public class ContaDAO extends GenericDAO<Conta> {

    @Override
    protected String getTableName() {
        return "T_CONTA";
    }

    @Override
    protected String getInsertSQL() {
        return "INSERT INTO T_CONTA (NUM_CONTA, NM_TITULAR, VL_SALDO, TP_CONTA) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void setInsertValues(PreparedStatement ps, Conta conta) throws SQLException {
        ps.setString(1, conta.getNumeroConta());
        ps.setString(2, conta.getTitular());
        ps.setDouble(3, conta.getSaldo());
        ps.setString(4, conta.getTypeConta());
    }

    @Override
    protected Conta createEntity(ResultSet rs) throws SQLException {
        String numeroConta = rs.getString("NUM_CONTA");
        String titular = rs.getString("NM_TITULAR");
        double saldo = rs.getDouble("VL_SALDO");
        String tipo = rs.getString("TP_CONTA");

        Conta conta = new ContaCorrente(numeroConta, titular, saldo);
        conta.setTypeConta(tipo);
        return conta;
    }
}
