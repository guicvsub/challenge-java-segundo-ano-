package testes;

import com.mycompany.projetochallenge.model.Mecanico;
import com.mycompany.projetochallenge.model.SistemaRanqueamento;

public class MecanicoTest {
    public static void main(String[] args) {
        // Criando o sistema de ranqueamento fictício para o teste
        SistemaRanqueamento sistemaRanqueamento = new SistemaRanqueamento();

        // Criando o Mecanico
        Mecanico mecanico = new Mecanico("Carlos Pereira", "carlos.pereira@email.com", "senha123", "Mecânico de Freios", 10, sistemaRanqueamento);

        // Testando os métodos
        System.out.println("ID: " + mecanico.getId());
        System.out.println("Nome: " + mecanico.getNome());
        System.out.println("Especialidade: " + mecanico.getEspecialidade());
        System.out.println("Experiência: " + mecanico.getExperiencia());

        // Testando os métodos próprios
        mecanico.consultarPedidos();
        mecanico.responderConsulta();

        // Testando a avaliação
        System.out.println("Sistema de Ranqueamento:");
        mecanico.receberAvaliacao(4); // Avaliar com uma nota 4
        mecanico.receberAvaliacao(5); // Avaliar com uma nota 5

        // Testando o login
        System.out.println("Login bem-sucedido? " + mecanico.realizarLogin());
    }
}
