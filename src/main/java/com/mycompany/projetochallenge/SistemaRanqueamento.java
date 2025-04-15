// Arquivo: SistemaRanqueamento.java
package com.mycompany.projetochallenge;

import com.mycompany.projetochallenge.model.Mecanico;

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

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
