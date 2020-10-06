package br.com.emanuelgabriel.dtos;

import java.util.Objects;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String nome;

    public UsuarioDTO(Long id, String login, String nome) {
        this.id = id;
        this.login = login;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
