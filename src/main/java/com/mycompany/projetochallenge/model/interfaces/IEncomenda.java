/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projetochallenge.model.interfaces;

import com.mycompany.projetochallenge.model.Cliente;
import com.mycompany.projetochallenge.model.Mecanico;
import com.mycompany.projetochallenge.model.Peca;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author gui
 */
public interface IEncomenda {

    int getIdEncomenda();
    Cliente getCliente();
    Mecanico getMecanico();
    List<Peca> getListaPecas();

    void agendarVistoria(Date data);
    void encomendarPecas();
}

