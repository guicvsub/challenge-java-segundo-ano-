package com.mycompany.projetochallenge.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.projetochallenge.model.Cliente;

import config.ConexaoDB;

public class ClienteDAO {
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    public void criarTabela() {
        final String sql = "CREATE TABLE cliente ("
                + "id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, "
                + "nome VARCHAR(255) NOT NULL, "
                + "email VARCHAR(255) NOT NULL, "
                + "senha VARCHAR(255) NOT NULL, "
                + "telefone VARCHAR(20) NOT NULL)";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement()) {
            LOG.info("Tabela 'cliente' em processo de criação!!!");
            stmt.execute(sql);
            LOG.info("Tabela 'cliente' criada com sucesso!!!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public void removerTabela() {
        final String sql = "DROP TABLE cliente";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement()) {
            LOG.info("Tabela 'cliente' em processo de REMOÇÃO!!!");
            stmt.execute(sql);
            LOG.info("Tabela 'cliente' removida com sucesso!!!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public Cliente adicionarCliente(final Cliente cliente) {
        final String sql = "INSERT INTO cliente(nome, email, senha, telefone) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            LOG.info("Cliente em processo de persistência!!!!");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getTelefone());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return new Cliente(
                        rs.getInt(1),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getSenha(),
                        cliente.getTelefone()
                    );
                }
            }
            
            LOG.info("Cliente Criado!");
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
    
    public Cliente atualizarCliente(final Cliente cliente) {
        final String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ?, telefone = ? WHERE id = ?";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            LOG.info("Cliente em processo de Atualização!!!!");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
            
            LOG.info("Cliente Atualizado!");
            return cliente;
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
    
    public void removerCliente(int id) {
        final String sql = "DELETE FROM cliente WHERE id = ?";
        
        LOG.info("Cliente em processo de remoção!!!!");
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            LOG.info("Cliente Removido!");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
    }
    
    public Set<Cliente> listar() {
        Set<Cliente> clientes = new HashSet<>();
        String sql = "SELECT * FROM cliente";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone")
                );
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return clientes;
    }
    
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone")
                );
            }
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }
    
    public Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?";
        
        try (Connection conn = ConexaoDB.getInstance().getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone")
                );
            }
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao acessar Banco de Dados: " + ex.getMessage(), ex);
        }
        return null;
    }

    Cliente buscarClientePorId(int encomendaId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
