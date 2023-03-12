package com.api.granjacontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CADASTROUSUARIO")
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

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
