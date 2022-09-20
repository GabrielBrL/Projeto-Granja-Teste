package com.api.granjacontrol.repository;

import com.api.granjacontrol.model.CadastroCiclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CadastroCicloRepository extends JpaRepository<CadastroCiclo, UUID> {

}
