package com.api.granjacontrol.service;

import com.api.granjacontrol.model.CadastroCiclo;
import com.api.granjacontrol.repository.CadastroCicloRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CicleService {

    final CadastroCicloRepository cadastroCicloRepository;

    public CicleService(CadastroCicloRepository cadastroCicloRepository) {
        this.cadastroCicloRepository = cadastroCicloRepository;
    }

    @Transactional
    public CadastroCiclo save(CadastroCiclo cadastroCiclo) {
        return cadastroCicloRepository.save(cadastroCiclo);
    }

    public Page<CadastroCiclo> findAll(Pageable pageable) {
        return cadastroCicloRepository.findAll(pageable);
    }

    public List<CadastroCiclo> findAll() {
        return cadastroCicloRepository.findAll();
    }

    public Optional<CadastroCiclo> findById(UUID id) {
        return cadastroCicloRepository.findById(id);
    }

    @Transactional
    public void delete(CadastroCiclo cadastroCiclo) {
        cadastroCicloRepository.delete(cadastroCiclo);
    }

    public void update(CadastroCiclo cadastroCiclo, UUID id){
        Optional<CadastroCiclo> ciclo = cadastroCicloRepository.findById(id);
        ciclo.get().setRaca(cadastroCiclo.getRaca());
        ciclo.get().setQuantidade(cadastroCiclo.getQuantidade());
        ciclo.get().setPeso(cadastroCiclo.getPeso());
        cadastroCicloRepository.save(ciclo.get());
    }
}
