package com.mycompany.projetochallenge.model;

import com.mycompany.projetochallenge.model.interfaces.IMecanico;

public class Mecanico implements IMecanico {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String especialidade;
    private int experiencia;
    private SistemaRanqueamento sistemaRanqueamento;

    public Mecanico(String nome, String email, String senha, String especialidade, int experiencia, SistemaRanqueamento sistemaRanqueamento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.sistemaRanqueamento = sistemaRanqueamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mecanico(String especialidade, int experiencia, SistemaRanqueamento sistemaRanqueamento, int id, String nome, String email, String senha) {
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.sistemaRanqueamento = sistemaRanqueamento;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Métodos próprios
    public void consultarPedidos() {
        System.out.println("Consultando pedidos");
    }

    public void responderConsulta() {
        System.out.println("Respondendo consulta");
    }

    // Implementação de IMecanico
    @Override
    public SistemaRanqueamento getSistemaRanqueamento() {
        return sistemaRanqueamento;
    }

    @Override
    public void receberAvaliacao(int nota) {
        if (sistemaRanqueamento != null) {
            sistemaRanqueamento.adicionarNota(nota);
        } else {
            System.out.println("Sistema de ranqueamento não está definido.");
        }
    }

    // Implementação de IUsuario
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean realizarLogin() {
        // Lógica de login simples — você pode adaptar
        return email != null && senha != null && !email.isEmpty() && !senha.isEmpty();
    }

    // Getters e setters adicionais
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setSistemaRanqueamento(SistemaRanqueamento sistemaRanqueamento) {
        this.sistemaRanqueamento = sistemaRanqueamento;
    }

    @Override
    public void setNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
