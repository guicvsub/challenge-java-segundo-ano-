/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projetochallenge.model.interfaces;

/**
 *
 * @author gui
 */
public interface IPeca {
    
/**
 *
 * @author gui
     * @return 
 */

 
    int getIdPeca();
    String getDescricao();
    double getPreco();
    String getImagem();
    
    void setDescricao(String descricao);
    void setPreco(double preco);
    void setImagem(String imagem);
    
    void exibirDetalhes();
}


