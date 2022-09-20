package com.api.granjacontrol.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "GRANJA_DB")
@Getter
@Setter
public class CadastroCiclo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "peso", nullable = false, length = 100)
    private String peso;

    @Column(name = "quantidade", nullable = false, length = 100)
    private Integer quantidade;

    @Column(name = "raca", nullable = false, length = 100)
    private String raca;

    @Column(nullable = false)
    private LocalDate registrationDate;
}
