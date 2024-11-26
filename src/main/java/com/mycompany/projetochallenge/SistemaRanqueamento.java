/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge;

/**
 *
 * @author gui
 */
public class SistemaRanqueamento {
     private int idRanqueamento;
    private Mecanico mecanico;
    private double notaMedia;
    private int totalAvaliacoes;

    public SistemaRanqueamento(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public void atualizarNota(int novaNota) {
        totalAvaliacoes++;
        notaMedia = ((notaMedia * (totalAvaliacoes - 1)) + novaNota) / totalAvaliacoes;
        System.out.println("Nova nota média: " + notaMedia);
    }

    // Getters e Setters omitidos para simplicidade
}

// Classe VisaoComputacional
class VisaoComputacional {
    public Peca identificarPeca(String imagem) {
        System.out.println("Identificando peça pela imagem");
        return new Peca(); // Simulação
    }
    
    
    
}
