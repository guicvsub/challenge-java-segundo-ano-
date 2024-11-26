/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge;

/**
 *
 * @author gui
 */
public class Mecanico extends Usuario {
    private String especialidade;
    private int experiencia;
    private SistemaRanqueamento sistemaRanqueamento;

    public Mecanico(String especialidade, int experiencia, SistemaRanqueamento sistemaRanqueamento, int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.sistemaRanqueamento = sistemaRanqueamento;
    }

    

    public void consultarPedidos() {
        System.out.println("Consultando pedidos");
    }

    public void responderConsulta() {
        System.out.println("Respondendo consulta");
    }

    public SistemaRanqueamento getSistemaRanqueamento() {
        return sistemaRanqueamento;
    }

  
}