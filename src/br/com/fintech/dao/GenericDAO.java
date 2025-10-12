package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> implements DAO<T> {

    protected abstract String getTableName();

    protected abstract void setInsertValues(PreparedStatement ps, T entity) throws SQLException;

    protected abstract T createEntity(ResultSet rs) throws SQLException;

    protected abstract String getInsertSQL();

    @Override
    public void insert(T entity) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(getInsertSQL())) {

            setInsertValues(ps, entity);
            ps.executeUpdate();
            System.out.println("Registro inserido com sucesso na tabela " + getTableName());

        } catch (SQLException e) {
            System.err.println("Erro ao inserir na tabela " + getTableName() + ": " + e.getMessage());
        }
    }

    @Override
    public List<T> getAll() {
        List<T> lista = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(createEntity(rs));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros da tabela " + getTableName() + ": " + e.getMessage());
        }
        return lista;
    }
}
