package com.api.granjacontrol.controller;

import com.api.granjacontrol.dto.CicleDto;
import com.api.granjacontrol.model.CadastroCiclo;
import com.api.granjacontrol.service.CicleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cicle")
public class CicleController {

    final CicleService cicleService;

    public CicleController(CicleService cicleService) {
        this.cicleService = cicleService;
    }

    @PostMapping
    public String saveCicle(Model model, @Valid @ModelAttribute CicleDto cicleDto){
        var cicloModel = new CadastroCiclo();
        BeanUtils.copyProperties(cicleDto, cicloModel);
        cicloModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")).toLocalDate());
        cicleService.save(cicloModel);
        return "redirect:/cicle";
    }

    @GetMapping
    public String getAllCicle(ModelMap model){
        var allValues =  cicleService.findAll();
        model.addAttribute("allValues", allValues);
        model.addAttribute("cicle", new CadastroCiclo());
        model.getAttribute("usuario");
        return "home/index";
    }
    @GetMapping("/{id}")
    public String getOneCicle(@PathVariable(value = "id") UUID id, Model model){
        Optional<CadastroCiclo> cicleServicelOptional = cicleService.findById(id);
        if(!cicleServicelOptional.isPresent()){
            return "Not found!";
        }

        var value = cicleServicelOptional.get();
        model.addAttribute("value", value);
        return "home/cicle";
    }
    @GetMapping("/delete/{id}")
    public String deleteCicle(@PathVariable(value = "id") UUID id){
        Optional<CadastroCiclo> cicleServicelOptional = cicleService.findById(id);
        if(!cicleServicelOptional.isPresent()){
            return "Parking Spot not found!";
        }
        cicleService.delete(cicleServicelOptional.get());

        return "redirect:/cicle";
    }
    @GetMapping("/edit/{id}")
    public String getOneCicleToEdit(@PathVariable(value = "id") UUID id, Model model){
        Optional<CadastroCiclo> cicleServicelOptional = cicleService.findById(id);
        if(!cicleServicelOptional.isPresent()){
            return "Not found!";
        }

        var value = cicleServicelOptional.get();
        model.addAttribute("value", value);
        return "home/edit";
    }
    @PostMapping("/edit/{id}")
    public String updateCicle(@PathVariable(value = "id") UUID id,
                                                    @Valid @ModelAttribute CicleDto cicleDto){
        Optional<CadastroCiclo> cicloOptional = cicleService.findById(id);
        if(!cicloOptional.isPresent()){
            return "Cicle not found.";
        }
        //cicleService.delete(cicloOptional.get());
        var cicleModel = new CadastroCiclo();
        BeanUtils.copyProperties(cicleDto, cicleModel);
        cicleService.update(cicleModel, cicloOptional.get().getId());
        return "redirect:/cicle";
    }
}
