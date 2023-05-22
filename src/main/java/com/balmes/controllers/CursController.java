package com.balmes.controllers;

import com.balmes.model.Curs;
import com.balmes.service.CursService;
import com.balmes.service.EstudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CursController {

    @Autowired
    EstudiantService estudiantService;

    @Autowired
    CursService cursService;

    @GetMapping("/curs")
    public String mostrarCurs(Model model)
    {
        List<Curs> cursList = cursService.getCurs();
        model.addAttribute("cursos", cursList);
        return "curs/listaCurs";
    }

    @GetMapping("/afegirCurs")
    public String anadirCurso(Model model){
        model.addAttribute("curso", new Curs());
        return "curs/formularioCurs";
    }

    @PostMapping("/afegirCurs")
    public String checkCurso(@ModelAttribute("curso") Curs curs, Errors errors){
        if (errors.hasErrors()){
            return "curs/formularioCurs";
        }
        cursService.saveCurs(curs);
        return "redirect:/curs";
    }
}