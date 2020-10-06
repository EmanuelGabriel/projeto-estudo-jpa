package br.com.emanuelgabriel.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Dominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "dominio")
    private List<Usuario> usuarios;

    public Dominio() {
    }

    public Dominio(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dominio dominio = (Dominio) o;
        return getId().equals(dominio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Dominio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
