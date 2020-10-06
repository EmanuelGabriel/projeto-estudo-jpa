package br.com.emanuelgabriel;

import br.com.emanuelgabriel.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConsultasJPQLJoin {

    public static void main(String[] args) {

        /**
         * Configuração do EntityManager
         */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Projeto-JPA-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /**
         * Executar código aqui
         */

        //fazerJoins(entityManager);
        fazerLeftJoin(entityManager);


        /**
         * Fechando a conexão
         */
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void fazerLeftJoin(EntityManager entityManager) {
        String jpqlJoin = "select u, c from Usuario u left join u.configuracao c";
        TypedQuery<Object[]> usuarioTypedQuery = entityManager.createQuery(jpqlJoin, Object[].class);
        List<Object[]> lista = usuarioTypedQuery.getResultList();
        lista.forEach(arr -> {
            String out = ((Usuario) arr[0]).getNome();
            if (arr.length > 1) {

            }
        });
    }

    private static void fazerJoins(EntityManager entityManager) {
        String jpqlJoin = "select u from Usuario u join u.dominio d where d.id = 1";
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpqlJoin, Usuario.class);
        List<Usuario> lista = usuarioTypedQuery.getResultList();
        lista.forEach(usuario -> System.out.println("--Dados--\n" + usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin()));
    }
}
