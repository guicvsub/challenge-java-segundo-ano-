package config;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConexaoDB {

    private static ConexaoDB instancia;
    private Connection conexao;

    private ConexaoDB() {
        try {
            // Carregar configurações do application.properties
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/application.properties"));

            String url = props.getProperty("db.url");
            String usuario = props.getProperty("db.user");
            String senha = props.getProperty("db.password");
            String driver = props.getProperty("db.driver");

            // Registrar driver do Oracle
            Class.forName(driver);

            // Criar conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conectado ao Oracle Database!");

        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException("❌ Erro ao conectar ao Oracle Database", e);
        }
    }

    // Método para obter a instância única
    public static ConexaoDB getInstance() {
        if (instancia == null) {
            instancia = new ConexaoDB();
        }
        return instancia;
    }

    // Método para obter a conexão
    public Connection getConexao() {
        return conexao;
    }

    // Método para fechar a conexão
    public void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("🔌 Conexão com Oracle fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
