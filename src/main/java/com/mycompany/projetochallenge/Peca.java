/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge;

/**
 *
 * @author gui
 */
class Peca {
    private int idPeca;
    private String descricao;
    private double preco;
    private String imagem;

    public void exibirDetalhes() {
        System.out.println("Descrição: " + descricao + ", Preço: " + preco);
    }

    // Getters e Setters omitidos para simplicidade
}
