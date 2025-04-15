package com.mycompany.projetochallenge.model;

/**
 * Representa o sistema de ranqueamento dos mecânicos.
 * Calcula média com base nas avaliações recebidas.
 * 
 * @author gui
 */
public class SistemaRanqueamento {
    private int id;
    private String nome;
    private int somaNotas;
    private int quantidadeAvaliacoes;

    public SistemaRanqueamento() {
    }

    public SistemaRanqueamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.somaNotas = 0;
        this.quantidadeAvaliacoes = 0;
    }

    public void adicionarNota(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        somaNotas += nota;
        quantidadeAvaliacoes++;
    }

    public void atualizarNota(int notaAntiga, int novaNota) {
        if (notaAntiga < 0 || novaNota < 0 || notaAntiga > 10 || novaNota > 10) {
            throw new IllegalArgumentException("Notas devem estar entre 0 e 10.");
        }
        somaNotas = somaNotas - notaAntiga + novaNota;
        // quantidadeAvaliacoes permanece a mesma
    }

    public double getNotaMedia() {
        if (quantidadeAvaliacoes == 0) return 0;
        return (double) somaNotas / quantidadeAvaliacoes;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSomaNotas() {
        return somaNotas;
    }

    public void setSomaNotas(int somaNotas) {
        this.somaNotas = somaNotas;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "SistemaRanqueamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", media=" + getNotaMedia() +
                ", avaliacoes=" + quantidadeAvaliacoes +
                '}';
    }
}
