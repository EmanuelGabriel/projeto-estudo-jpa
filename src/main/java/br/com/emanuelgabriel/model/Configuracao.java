package br.com.emanuelgabriel.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapsId
    @OneToOne
    private Usuario usuario;

    private boolean receberNotificacoes;

    private boolean encerrarSessaoAutomatica;

    public Configuracao() {
    }

    public Configuracao(Long id, Usuario usuario, boolean receberNotificacoes, boolean encerrarSessaoAutomatica) {
        this.id = id;
        this.usuario = usuario;
        this.receberNotificacoes = receberNotificacoes;
        this.encerrarSessaoAutomatica = encerrarSessaoAutomatica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }

    public boolean isEncerrarSessaoAutomatica() {
        return encerrarSessaoAutomatica;
    }

    public void setEncerrarSessaoAutomatica(boolean encerrarSessaoAutomatica) {
        this.encerrarSessaoAutomatica = encerrarSessaoAutomatica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuracao that = (Configuracao) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", receberNotificacoes=" + receberNotificacoes +
                ", encerrarSessaoAutomatica=" + encerrarSessaoAutomatica +
                '}';
    }
}
