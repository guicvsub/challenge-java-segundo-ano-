package com.mycompany.projetochallenge.datasource;

import com.mycompany.projetochallenge.model.Usuario;
import config.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    
    public void criarTabela() {
        final String sql = "CREATE TABLE usuario ("
                + "id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, "
                + "nome VARCHAR(255) NOT NULL, "
                + "email VARCHAR(255) NOT NULL, "
                + "senha VARCHAR(255) NOT NULL)";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement()) {
            LOG.info("Tabela 'usuario' em processo de criação!!!");
            stmt.execute(sql);
            LOG.info("Tabela 'usuario' criada com sucesso!!!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public void removerTabela() {
        final String sql = "DROP TABLE usuario";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement()) {
            LOG.info("Tabela 'usuario' em processo de REMOÇÃO!!!");
            stmt.execute(sql);
            LOG.info("Tabela 'usuario' removida com sucesso!!!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public Usuario adicionarUsuario(final Usuario usuario) {
        final String sql = "INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            LOG.info("Usuario em processo de persistência!!!!");
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }
            
            LOG.info("Usuario Criado!");
            return usuario;
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
    
    public Usuario atualizarUsuario(final Usuario usuario) {
        final String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            LOG.info("Usuario em processo de Atualização!!!!");
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            
            LOG.info("Usuario Atualizado!");
            return usuario;
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
    
    public void removerUsuario(int id) {
        final String sql = "DELETE FROM usuario WHERE id = ?";
        
        LOG.info("Usuario em processo de remoção!!!!");
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            LOG.info("Usuario Removido!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public Set<Usuario> listar() {
        Set<Usuario> usuarios = new HashSet<>();
        String sql = "SELECT * FROM usuario";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Usuario user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
                usuarios.add(user);
            }
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return usuarios;
    }
    
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
}
