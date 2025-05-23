package com.mycompany.projetochallenge.datasource;

import com.mycompany.projetochallenge.model.Mecanico;
import com.mycompany.projetochallenge.model.SistemaRanqueamento;
import config.ConexaoDB;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MecanicoDAO {
    private static final Logger LOG = Logger.getLogger(MecanicoDAO.class.getName());

    public void criarTabela() {
        final String sql = """
            CREATE TABLE mecanico (
                id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                nome VARCHAR(255) NOT NULL,
                email VARCHAR(255) NOT NULL,
                senha VARCHAR(255) NOT NULL,
                especialidade VARCHAR(255) NOT NULL,
                experiencia INTEGER NOT NULL,
                id_sistema_ranqueamento INTEGER,
                FOREIGN KEY (id_sistema_ranqueamento) REFERENCES sistema_ranqueamento(id)
            )""";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             Statement stmt = conn.createStatement()) {

            LOG.info("Criando tabela 'mecanico'...");
            stmt.execute(sql);
            LOG.info("Tabela 'mecanico' criada com sucesso!");

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao criar tabela 'mecanico': " + ex.getMessage(), ex);
        }
    }

    public void removerTabela() {
        final String sql = "DROP TABLE mecanico";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             Statement stmt = conn.createStatement()) {

            LOG.info("Removendo tabela 'mecanico'...");
            stmt.execute(sql);
            LOG.info("Tabela 'mecanico' removida com sucesso!");

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao remover tabela 'mecanico': " + ex.getMessage(), ex);
        }
    }

    public Mecanico adicionarMecanico(final Mecanico mecanico) {
        final String sql = "INSERT INTO mecanico(nome, email, senha, especialidade, experiencia, id_sistema_ranqueamento) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            LOG.info("Persistindo novo mecânico...");

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEmail());
            stmt.setString(3, mecanico.getSenha());
            stmt.setString(4, mecanico.getEspecialidade());
            stmt.setInt(5, mecanico.getExperiencia());

            if (mecanico.getSistemaRanqueamento() != null) {
                stmt.setInt(6, mecanico.getSistemaRanqueamento().getId());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    mecanico.setId(rs.getInt(1));
                    LOG.info("Mecânico criado com ID: " + mecanico.getId());
                    return mecanico;
                }
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao adicionar mecânico: " + ex.getMessage(), ex);
        }
        return null;
    }

    public Mecanico atualizarMecanico(final Mecanico mecanico) {
        final String sql = "UPDATE mecanico SET nome = ?, email = ?, senha = ?, "
                         + "especialidade = ?, experiencia = ?, id_sistema_ranqueamento = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            LOG.info("Atualizando mecânico ID " + mecanico.getId());

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEmail());
            stmt.setString(3, mecanico.getSenha());
            stmt.setString(4, mecanico.getEspecialidade());
            stmt.setInt(5, mecanico.getExperiencia());

            if (mecanico.getSistemaRanqueamento() != null) {
                stmt.setInt(6, mecanico.getSistemaRanqueamento().getId());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }

            stmt.setInt(7, mecanico.getId());
            stmt.executeUpdate();

            LOG.info("Mecânico atualizado com sucesso!");
            return mecanico;

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao atualizar mecânico: " + ex.getMessage(), ex);
        }
        return null;
    }

    public void removerMecanico(int id) {
        final String sql = "DELETE FROM mecanico WHERE id = ?";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            LOG.info("Removendo mecânico ID " + id);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            LOG.info("Mecânico removido com sucesso!");

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao remover mecânico: " + ex.getMessage(), ex);
        }
    }

    public Set<Mecanico> listar() {
        Set<Mecanico> mecanicos = new HashSet<>();
        final String sql = "SELECT m.*, sr.id AS sr_id, sr.nome AS sr_nome FROM mecanico m "
                         + "LEFT JOIN sistema_ranqueamento sr ON m.id_sistema_ranqueamento = sr.id";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SistemaRanqueamento sr = null;
                if (rs.getObject("sr_id") != null) {
                    sr = new SistemaRanqueamento(rs.getInt("sr_id"), rs.getString("sr_nome"));
                }

                Mecanico mecanico = new Mecanico(
                    rs.getString("especialidade"),
                    rs.getInt("experiencia"),
                    sr,
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );

                mecanicos.add(mecanico);
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao listar mecânicos: " + ex.getMessage(), ex);
        }

        return mecanicos;
    }

    public Mecanico buscarPorId(int id) {
        final String sql = "SELECT m.*, sr.id AS sr_id, sr.nome AS sr_nome FROM mecanico m "
                         + "LEFT JOIN sistema_ranqueamento sr ON m.id_sistema_ranqueamento = sr.id WHERE m.id = ?";

        try (Connection conn = ConexaoDB.getInstance().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    SistemaRanqueamento sr = null;
                    if (rs.getObject("sr_id") != null) {
                        sr = new SistemaRanqueamento(rs.getInt("sr_id"), rs.getString("sr_nome"));
                    }

                    return new Mecanico(
                        rs.getString("especialidade"),
                        rs.getInt("experiencia"),
                        sr,
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                    );
                }
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Erro ao buscar mecânico por ID: " + ex.getMessage(), ex);
        }

        return null;
    }

    Mecanico buscarMecanicoPorId(int encomendaId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
