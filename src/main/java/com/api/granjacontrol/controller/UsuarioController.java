package com.api.granjacontrol.controller;

import com.api.granjacontrol.model.CadastroCiclo;
import com.api.granjacontrol.model.CadastroUsuario;
import com.api.granjacontrol.service.CicleService;
import com.api.granjacontrol.service.CookieService;
import com.api.granjacontrol.service.UsuarioService;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/login")
    public String getFormUsuarioExistente(){
        return "usuario/login";
    }

    @PostMapping("/cadastro")
    public String salvarNovoUsuario(@ModelAttribute(name = "cadastroForm")CadastroUsuario cadastroUsuario, Model model){
        cadastroUsuario.setDataCadastro(LocalDate.now());
        usuarioService.save(cadastroUsuario);
        var usuario = cadastroUsuario;
        model.addAttribute("usuario", usuario);
        model.addAttribute("cicle", new CadastroCiclo());
        return "redirect:/cicle";
    }

    @PostMapping("/login")
    public String conectarSistema(@ModelAttribute(name = "loginForm")CadastroUsuario cadastroUsuario, Model model, HttpServletResponse response){
        var usuario = usuarioService.findByUser(cadastroUsuario.getUsername(), cadastroUsuario.getSenha());
        if(usuario == null){
            model.addAttribute("erro", "Usuário e senha não encontrados.");
            return "usuario/login";
        }
        CookieService.setCookie(response,"user", usuario.getApelido());
        model.addAttribute("cicle", new CadastroCiclo());
        return "redirect:/cicle";
    }

    @GetMapping("/sair")
    public String deslogarUsuario(Model model, HttpServletRequest response){
        var usuario = new CadastroUsuario();
        var userCookie = CookieService.getCookie(response,"user");
        model.addAttribute("cicle", new CadastroCiclo());
        return "redirect:/cicle";
    }
}
