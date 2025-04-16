/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import com.mycompany.projetochallenge.model.Cliente;

/**
 *
 * @author gui
*/

public class ClienteTest {

    public static void main(String[] args) {
        // Criação de um cliente
        Cliente cliente = new Cliente(1, "João Silva", "joao.silva@email.com", "senha123", "1234-5678");
        
        // Exibição das propriedades do cliente
        System.out.println("Testando a classe Cliente:");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Telefone: " + cliente.getTelefone());
        
        // Testando o método toString
        System.out.println("\nUsando o método toString():");
        System.out.println(cliente);
        
        // Alterando alguns dados e exibindo novamente
        cliente.setNome("João Souza");
        cliente.setTelefone("9876-5432");
        System.out.println("\nApós alterações:");
        System.out.println(cliente);
    }
}
