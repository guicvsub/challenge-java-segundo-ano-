/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge.model;

import com.mycompany.projetochallenge.model.interfaces.IPeca;

/**
 *
 * @author gui

/**
 *
 * @author gui
 */
public class Peca implements IPeca {
    private final int idPeca;
    private String descricao;
    private double preco;
    private String imagem;

    public Peca(int idPeca, String descricao, double preco, String imagem) {
        this.idPeca = idPeca;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    @Override
    public int getIdPeca() {
        return idPeca;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getImagem() {
        return imagem;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Descrição: " + descricao + ", Preço: R$" + preco + ", Imagem: " + imagem);
    }
}

