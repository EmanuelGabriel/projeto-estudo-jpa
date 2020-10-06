package br.com.emanuelgabriel;

import br.com.emanuelgabriel.dtos.UsuarioDTO;
import br.com.emanuelgabriel.model.Dominio;
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

        /**
         * Executar código aqui
         */


        //primeiraConsulta(entityManager);
        //primeiraConsultaJPQL(entityManager);
        //escolhendoRetorno(entityManager);
        //listarNomeUsuarios(entityManager);
        //fazendoProjecoes(entityManager);
        //fazendoProjecoesDTO(entityManager);
        //passarParamentrosQuery(entityManager);
        //passarParamentrosQuery2(entityManager);
        passarParamentrosQuery3(entityManager);

        /**
         * Fechando a conexão
         */
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void passarParamentrosQuery3(EntityManager entityManager) {
        String jpqlParam = "select u from Usuario u where u.nome = :nome and u.login = :login";

        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpqlParam, Usuario.class)
                .setParameter("nome", "Carla do Nascimento")
                .setParameter("login", "carla");

        Usuario usuario = usuarioTypedQuery.getSingleResult();
        System.out.println("--Dados--\nUsuário: " + usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin());
    }

    private static void passarParamentrosQuery2(EntityManager entityManager) {
        String jpqlParam = "select u from Usuario u where u.nome = :nome";

        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpqlParam, Usuario.class)
                .setParameter("nome", "Carla do Nascimento");

        Usuario usuario = usuarioTypedQuery.getSingleResult();
        System.out.println("--Dados--\nUsuário: " + usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin());
    }

    private static void passarParamentrosQuery(EntityManager entityManager) {
        String jpqlParam = "select u from Usuario u where u.id = :id";

        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpqlParam, Usuario.class)
                .setParameter("id", 3L);

        Usuario usuario = usuarioTypedQuery.getSingleResult();
        System.out.println("--Dados--\nUsuário: " + usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin());
    }

    private static void fazendoProjecoesDTO(EntityManager entityManager) {
        String jpqlDTO = "SELECT new br.com.emanuelgabriel.dtos.UsuarioDTO(id, login, nome) FROM Usuario";
        TypedQuery<UsuarioDTO> typedQueryUsuarioDTO = entityManager.createQuery(jpqlDTO, UsuarioDTO.class);
        List<UsuarioDTO> listaUsuarioDTO = typedQueryUsuarioDTO.getResultList();
        listaUsuarioDTO.forEach(usuarioDto -> System.out.println(usuarioDto.getId() + ", " + usuarioDto.getLogin() + ", " + usuarioDto.getNome()));
    }

    private static void fazendoProjecoes(EntityManager entityManager) {
        String jpqlArray = "select id, login, nome from Usuario";
        TypedQuery<Object[]> typedQueryArray = entityManager.createQuery(jpqlArray, Object[].class);
        List<Object[]> listaArray = typedQueryArray.getResultList();
        listaArray.forEach(arrays -> System.out.println(String.format("%s, %s, %s", arrays)));
    }

    private static void listarNomeUsuarios(EntityManager entityManager) {
        String jpql = "select u.nome from Usuario u";
        TypedQuery<String> typedQueryNome = entityManager.createQuery(jpql, String.class);
        List<String> listaNomes = typedQueryNome.getResultList();
        listaNomes.forEach(nome -> System.out.println("Dados\nNome: " + nome));

    }

    private static void escolhendoRetorno(EntityManager entityManager) {
        String jpql = "select u.dominio from Usuario u where u.id = 1";
        TypedQuery<Dominio> dominioTypedQuery = entityManager.createQuery(jpql, Dominio.class);
        Dominio dominio = dominioTypedQuery.getSingleResult();
        System.out.println("Dados:\nDomínio: " + dominio.getId() + ", " + dominio.getNome());
    }

    private static void updateUsuario(EntityManager entityManager) {
        String jpql = "update u from Usuario u where u.id = :id";
        Usuario usuarioUpdate = entityManager.find(Usuario.class, 1L);
        System.out.println(usuarioUpdate.getId() + ", " + usuarioUpdate.getLogin());
    }

    private static void primeiraConsulta(EntityManager entityManager) {
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = usuarioTypedQuery.getResultList();
        usuarios.forEach(usuario -> System.out.println(usuario.getId() + ", " + usuario.getNome() + ", " + usuario.getLogin()));
    }

    private static void primeiraConsultaJPQL(EntityManager entityManager) {
        String jpqlSingle = "select u from Usuario u where u.id = 1";
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpqlSingle, Usuario.class);
        Usuario usuario = usuarioTypedQuery.getSingleResult();
        System.out.println("Usuário: " + usuario.getId() + ", " + usuario.getNome());
    }

}
