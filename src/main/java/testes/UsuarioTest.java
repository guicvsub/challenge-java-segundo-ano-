/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;
package com.mycompany.projetochallenge.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gui
 */

class UsuarioTest {

    @Test
    void testConstrutorComId() {
        Usuario user = new Usuario(1, "João", "joao@email.com", "1234");

        assertEquals(1, user.getId());
        assertEquals("João", user.getNome());
        assertEquals("joao@email.com", user.getEmail());
        assertEquals("1234", user.getSenha());
    }

    @Test
    void testConstrutorSemId() {
        Usuario user = new Usuario("Maria", "maria@email.com", "abcd");

        assertEquals("Maria", user.getNome());
        assertEquals("maria@email.com", user.getEmail());
        assertEquals("abcd", user.getSenha());
    }

    @Test
    void testSettersAndGetters() {
        Usuario user = new Usuario("Pedro", "pedro@email.com", "xyz");
        user.setId(10);
        user.setNome("Pedro Silva");
        user.setEmail("pedrosilva@email.com");
        user.setSenha("senhaNova");

        assertEquals(10, user.getId());
        assertEquals("Pedro Silva", user.getNome());
        assertEquals("pedrosilva@email.com", user.getEmail());
        assertEquals("senhaNova", user.getSenha());
    }

    @Test
    void testEqualsAndHashCode() {
        Usuario user1 = new Usuario(1, "Ana", "ana@email.com", "123");
        Usuario user2 = new Usuario(1, "Ana", "ana@email.com", "123");
        Usuario user3 = new Usuario(2, "Carlos", "carlos@email.com", "456");

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testToString() {
        Usuario user = new Usuario(5, "Bruna", "bruna@email.com", "pass");

        String expected = "Usuario{id=5, nome='Bruna', email='bruna@email.com'}";
        assertEquals(expected, user.toString());
    }

    @Test
    void testRealizarLoginNaoImplementado() {
        Usuario user = new Usuario(1, "Teste", "teste@email.com", "senha");

        assertThrows(UnsupportedOperationException.class, user::realizarLogin);
    }
}

