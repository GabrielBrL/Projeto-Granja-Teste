package com.api.granjacontrol.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CADASTROUSUARIO")
@Getter
@Setter
public class CadastroUsuario{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="username", nullable = false, length = 100)
    private String username;

    @Column(name="email", nullable = false, length = 255)
    private String email;

    @Column(name="senha", nullable = false, length = 10)
    private String senha;

    @Column(name = "apelido", nullable = false, length = 100)
    private String apelido;

    @Column(name = "dataCadastro", nullable = false, length = 100)
    private LocalDate dataCadastro;

    @Column(name = "funcao", nullable = false, length = 100)
    private String funcao;
}
