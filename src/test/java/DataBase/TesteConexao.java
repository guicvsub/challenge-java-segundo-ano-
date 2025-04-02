/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author gui
 */



import config.ConexaoDB;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("🔍 Testando conexão com o banco de dados...");

        // Obtendo a instância da conexão
        ConexaoDB conexaoDB = ConexaoDB.getInstance();
        Connection conexao = conexaoDB.getConexao();

        if (conexao != null) {
            System.out.println("✅ Conexão bem-sucedida!");
        } else {
            System.err.println("❌ Falha na conexão!");
        }

        // Fechando a conexão após o teste
        conexaoDB.fecharConexao();
    }
}
