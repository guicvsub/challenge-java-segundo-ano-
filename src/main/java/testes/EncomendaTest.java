package testes;

import com.mycompany.projetochallenge.model.Cliente;
import com.mycompany.projetochallenge.model.Mecanico;
import com.mycompany.projetochallenge.model.Peca;
import com.mycompany.projetochallenge.model.Encomenda;
import java.util.ArrayList;
import java.util.List;
/*
public class EncomendaTest {
    public static void main(String[] args) {
        // Criando objetos de teste para Cliente e Mecanico
        Cliente cliente = new Cliente(1, "João Silva", "joao.silva@email.com", "senha123", "1234-5678");
        Mecanico mecanico = new Mecanico(1, "Carlos Pereira", "carlos.pereira@email.com", "9876-5432");

        // Criando uma lista de peças
        List<Peca> pecas = new ArrayList<>();
        Peca peca1 = new Peca(1, "Pastilha de Freio", 150.0);
        Peca peca2 = new Peca(2, "Amortecedor", 300.0);
        pecas.add(peca1);
        pecas.add(peca2);

        // Criando a encomenda
        Encomenda encomenda = new Encomenda(1, cliente, mecanico, pecas);

        // Testando o método exibirDetalhes()
        encomenda.exibirDetalhes();

        // Verificando se os detalhes estão corretos
        System.out.println("ID Encomenda: " + encomenda.getIdEncomenda());
        System.out.println("Cliente: " + encomenda.getCliente().getNome());
        System.out.println("Mecânico: " + encomenda.getMecanico().getNome());

        // Adicionando mais peças à encomenda e verificando novamente
        Peca peca3 = new Peca(3, "Filtro de Ar", 50.0);
        encomenda.setPecas(new ArrayList<>(List.of(peca1, peca2, peca3)));

        // Exibindo detalhes atualizados
        encomenda.exibirDetalhes();
    }
}
*/