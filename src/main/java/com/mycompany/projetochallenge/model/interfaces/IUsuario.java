/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projetochallenge.model.interfaces;

/**
 *

/**
 *

 */
public interface IUsuario {
    
    // Getters
    int getId();
    String getNome();
    String getEmail();
    String getSenha();
    
    // Setters
    void setEmail(String email);
    void setSenha(String senha);
    
    // Método de ação
    boolean realizarLogin();
}
