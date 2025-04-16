    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projetochallenge.model.interfaces;
import java.util.Date;
/**
 *
 * @author gui
 */
public interface IPedido {





    int getIdPedido();
    Date getDataCriacao();
    String getStatus();
    void atualizarStatus(String novoStatus);
}

    

