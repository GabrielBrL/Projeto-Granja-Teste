package com.api.granjacontrol.repository;

import com.api.granjacontrol.model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, UUID> {
}
