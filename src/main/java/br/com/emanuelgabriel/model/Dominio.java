package br.com.emanuelgabriel.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "dominio")
    private List<Usuario> usuarios;


}
