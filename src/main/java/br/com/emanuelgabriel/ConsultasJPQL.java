package br.com.emanuelgabriel;

import br.com.emanuelgabriel.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConsultasJPQL {

    public static void main(String[] args) {

        /**
         * Configuração do EntityManager
         */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Usuarios-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // código aqui
        primeiraConsulta(entityManager);


        // fechando a conexão
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void primeiraConsulta(EntityManager entityManager) {

        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = usuarioTypedQuery.getResultList();
        usuarios.forEach(usuario -> System.out.println(usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin()));
    }
}
