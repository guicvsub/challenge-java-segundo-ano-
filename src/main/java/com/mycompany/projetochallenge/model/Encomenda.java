package com.mycompany.projetochallenge.model;

import com.mycompany.projetochallenge.model.interfaces.IEncomenda;
import java.sql.Date;
import java.util.List;

public class Encomenda implements IEncomenda {
    private final int idEncomenda;
    private Cliente cliente;
    private Mecanico mecanico;
    private List<Peca> pecas;

    public Encomenda(int idEncomenda, Cliente cliente, Mecanico mecanico, List<Peca> pecas) {
        this.idEncomenda = idEncomenda;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.pecas = pecas;
    }

    @Override
    public int getIdEncomenda() {
        return idEncomenda;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public Mecanico getMecanico() {
        return mecanico;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void exibirDetalhes() {
        System.out.println("ID Encomenda: " + idEncomenda);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Mecânico: " + mecanico.getNome());
        for (Peca peca : pecas) {
            peca.exibirDetalhes();
        }
    }

    @Override
    public List<Peca> getListaPecas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agendarVistoria(Date data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void encomendarPecas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
