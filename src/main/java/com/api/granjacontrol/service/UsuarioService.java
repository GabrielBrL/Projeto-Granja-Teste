package com.api.granjacontrol.service;

import com.api.granjacontrol.model.CadastroUsuario;
import com.api.granjacontrol.repository.CadastroUsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    final CadastroUsuarioRepository cadastroUsuarioRepository;

    public UsuarioService(CadastroUsuarioRepository cadastroUsuarioRepository){
        this.cadastroUsuarioRepository = cadastroUsuarioRepository;
    }

    @Transactional
    public CadastroUsuario save(CadastroUsuario cadastroUsuario){return cadastroUsuarioRepository.save(cadastroUsuario);}
    public List<CadastroUsuario> findAll(){return cadastroUsuarioRepository.findAll();}
    public Optional<CadastroUsuario> findById(UUID id){return cadastroUsuarioRepository.findById(id);}
}
