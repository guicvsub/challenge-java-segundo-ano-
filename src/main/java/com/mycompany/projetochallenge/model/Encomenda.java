/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetochallenge.model;

/**
 *
 * @author gui
 */


import com.mycompany.projetochallenge.model.interfaces.IEncomenda;
import java.util.Date;
import java.util.List;

public abstract class Encomenda implements IEncomenda {
    private int idEncomenda;
    private Cliente cliente;
    private Mecanico mecanico;
    private List<Peca> listaPecas;

    public Encomenda(int idEncomenda, Cliente cliente, Mecanico mecanico, List<Peca> listaPecas) {
        this.idEncomenda = idEncomenda;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.listaPecas = listaPecas;
    }

    @Override
    public int getIdEncomenda() {
        return idEncomenda;
    }

   

    @Override
    public Mecanico getMecanico() {
        return mecanico;
    }

    @Override
    public List<Peca> getListaPecas() {
        return listaPecas;
    }



    @Override
    public void encomendarPecas() {
        System.out.println("Peças encomendadas");
    }

    @Override
    public void agendarVistoria(java.sql.Date data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
