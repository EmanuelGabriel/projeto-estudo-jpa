package br.com.emanuelgabriel;

import br.com.emanuelgabriel.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePrincipal {

    public static void main(String[] args) {

        /**
         * Configuração do EntityManager
         */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Realizando testes
        // criarTabelas(entityManager);
//        Cliente cliente = entityManager.find(Cliente.class, 2L);

//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();

//        Cliente cliente = entityManager.find(Cliente.class, 1L);
//        entityManager.getTransaction().begin();
//        cliente.setNome("Jonas Alves Cabral");
//        entityManager.getTransaction().commit();


        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Construtora Medeiros Ltda");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();


        // fechando a conexão
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void criarTabelas(EntityManager entityManager) {
        Cliente cliente = entityManager.find(Cliente.class, 4L);
        System.out.println("Cliente:\n" + cliente.getNome());
    }


}
