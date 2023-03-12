package com.api.granjacontrol.repository;

import com.api.granjacontrol.model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, Long> {
    @Query(value = "select * from cadastrousuario where username = :username and senha = :senha",nativeQuery = true)
    CadastroUsuario findByUser(String username, String senha);
}
