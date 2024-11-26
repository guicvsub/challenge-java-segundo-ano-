/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge;


import java.util.Date;
import java.util.List;

/**
 *
 * @author gui
 */
public class Encomenda {
    private int idEncomenda;
    private Cliente cliente;
    private Mecanico mecanico;
    private List<Peca> listaPecas;

    public void agendarVistoria(Date data) {
        System.out.println("Vistoria agendada para: " + data);
    }

    public void encomendarPecas() {
        System.out.println("Peças encomendadas");
    }
    
}
