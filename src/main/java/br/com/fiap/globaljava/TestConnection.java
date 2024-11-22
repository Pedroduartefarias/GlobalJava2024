package br.com.fiap.globaljava;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/orcl";
        String username = "rm98469";
        String password = "040905";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}