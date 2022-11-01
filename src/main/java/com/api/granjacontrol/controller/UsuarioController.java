package com.api.granjacontrol.controller;

import com.api.granjacontrol.model.CadastroCiclo;
import com.api.granjacontrol.model.CadastroUsuario;
import com.api.granjacontrol.service.CicleService;
import com.api.granjacontrol.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;
    final CicleService cicleService;

    public UsuarioController(UsuarioService usuarioService, CicleService cicleService){
        this.usuarioService = usuarioService;
        this.cicleService = cicleService;
    }

    @GetMapping("/cadastro")
    public String getFormNovoUsuario(){
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarNovoUsuario(@ModelAttribute(name = "cadastroForm")CadastroUsuario cadastroUsuario, Model model){
        cadastroUsuario.setDataCadastro(LocalDate.now());

        usuarioService.save(cadastroUsuario);
        var usuario = cadastroUsuario;
        model.addAttribute("usuario", usuario);
        model.addAttribute("cicle", new CadastroCiclo());
        return "/home/index";
    }

    @GetMapping("/sair")
    public String deslogarUsuario(Model model){
        var usuario = new CadastroUsuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("cicle", new CadastroCiclo());
        return "/home/index";
    }
}
