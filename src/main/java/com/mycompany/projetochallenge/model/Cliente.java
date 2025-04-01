/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge.model;

import com.mycompany.projetochallenge.Mecanico;
import com.mycompany.projetochallenge.Usuario;

/**
 *
 * @author gui
 */
public class Cliente extends Usuario {
    private String telefone;

    public Cliente(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    public void consultarPecas() {
        System.out.println("Consultando peças disponíveis");
    }

    public void avaliarMecanico(Mecanico mecanico, int nota) {
        System.out.println("Avaliando mecânico " + mecanico.getNome() + " com nota " + nota);
        mecanico.getSistemaRanqueamento().atualizarNota(nota);
    }
}
