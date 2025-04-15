package com.mycompany.projetochallenge.model;

import java.util.List;
import java.sql.Date;

public class EncomendaConcreta extends Encomenda {
    
    public EncomendaConcreta(int id, Cliente cliente, Mecanico mecanico, List<Peca> pecas) {
        super(id, cliente, mecanico, pecas);
    }

    @Override
    public Cliente getCliente() {
        return super.getCliente();
    }

    @Override
    public Mecanico getMecanico() {
        return super.getMecanico();
    }

    @Override
    public List<Peca> getListaPecas() {
        return super.getListaPecas();
    }

    @Override
    public void agendarVistoria(Date data) {
        System.out.println("Vistoria agendada para: " + data);
        // Aqui você pode adicionar lógica real de persistência ou notificação
    }

    @Override
    public void encomendarPecas() {
        System.out.println("Encomenda de peças realizada com sucesso!");
        // Aqui você pode adicionar lógica para atualizar status ou salvar no banco
    }
}
