package com.balmes.controllers;

import com.balmes.model.Curs;
import com.balmes.model.Estudiant;
import com.balmes.repositories.CursRepository;
import com.balmes.repositories.EstudiantRepository;
import com.balmes.service.CursService;
import com.balmes.service.EstudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EstudiantController {
    @Autowired
    CursService cursService;
    @Autowired
    EstudiantService estudiantService;

    @GetMapping("/estudiant")
    public String mostrarEstudiant(Model model)
    {
        List<Estudiant> estudiantList = estudiantService.getStudents();
        model.addAttribute("estudiant", estudiantList);
        model.addAttribute("curs", cursService.getCurs());
        return "estudiant/listaEstudiant";
    }

    @GetMapping("/afegirEstudiant")
    public String anadirEstudiant(Model model){
        model.addAttribute("estudiant", new Estudiant());
        model.addAttribute("curs", cursService.getCurs());
        return ("estudiant/formularioEstudiant");
    }

    @PostMapping("/afegirEstudiant")
    public String checkEstudiant(@ModelAttribute("estudiant") Estudiant estudiant, Errors errors){
        System.out.println(estudiant);
        if (errors.hasErrors()){
            return "estudiant/formularioEstudiant";
        }
        estudiantService.saveStudent(estudiant);
        return "redirect:/estudiant";
    }
}
