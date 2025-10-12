package br.com.fintech.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Oracle não encontrado!");
        }

        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
        String user = "SEU_USUARIO";
        String password = "SUA_SENHA";

        return DriverManager.getConnection(url, user, password);
    }
}
