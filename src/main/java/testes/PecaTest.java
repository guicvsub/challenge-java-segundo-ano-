/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import com.mycompany.projetochallenge.model.Peca;

/**
 *
 * @author gui
 */


public class PecaTest {
    public static void main(String[] args) {
        // Criando uma peça com valores iniciais
        Peca peca = new Peca(101, "Filtro de óleo", 29.90, "imagem_filtro_oleo.jpg");

        // Exibindo os valores iniciais
        System.out.println("ID da Peça: " + peca.getIdPeca());
        System.out.println("Descrição: " + peca.getDescricao());
        System.out.println("Preço: R$" + peca.getPreco());
        System.out.println("Imagem: " + peca.getImagem());

        // Testando método exibirDetalhes()
        System.out.println("\n[Detalhes da Peça]");
        peca.exibirDetalhes();

        // Alterando os dados com os setters
        peca.setDescricao("Filtro de ar");
        peca.setPreco(45.50);
        peca.setImagem("imagem_filtro_ar.jpg");

        // Exibindo os valores atualizados
        System.out.println("\n[Após Atualização]");
        System.out.println("Descrição: " + peca.getDescricao());
        System.out.println("Preço: R$" + peca.getPreco());
        System.out.println("Imagem: " + peca.getImagem());

        // Exibindo detalhes novamente
        System.out.println("\n[Detalhes Atualizados]");
        peca.exibirDetalhes();
    }
}
