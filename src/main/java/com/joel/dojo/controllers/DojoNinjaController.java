package com.joel.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joel.dojo.models.Dojo;
import com.joel.dojo.models.Ninja;
import com.joel.dojo.repositories.DojoRepository;
import com.joel.dojo.servicies.ApiServicio;

@Controller
public class DojoNinjaController {

    @Autowired private DojoRepository repositorioDojo;
    @Autowired private ApiServicio apiServicio;
    
    //Principal
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //Mostrar All
    @GetMapping("/dojos")
    public String dash(Model model){
        List<Dojo> dojo=repositorioDojo.findAll();
        model.addAttribute("dojos", dojo);
        return "dojoNinjaPanel";
    }
    
    //Mostrar contenido por cada dojo
    @GetMapping("/dojos/{id}")
    public String viewIdDojo(@PathVariable Long id, Model model){
        Dojo dojo= apiServicio.getDojoById(id);
        List<Ninja> ninjas =apiServicio.getAllDojoWithNinja(id);
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        return "dojoDetail";
    }

    //Create new dojo
    @GetMapping("/dojos/new")
    public String viewAddDojo(Model model){
        model.addAttribute("dojo", new Dojo());
        return "dojo";
    }
    @PostMapping("/dojos/new")
    public String addDojo(@ModelAttribute("dojo") Dojo dojo){
        repositorioDojo.save(dojo);
        return "redirect:/dojos";
    }

    //Create new ninja
    @GetMapping("/ninjas/new")
    public String viewAddNinja(Model model){
        List<Dojo> dojos=apiServicio.getAllDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninja", new Ninja());
        return "ninja";
    }
    @PostMapping("/ninjas/new")
    public String addNinja(@ModelAttribute("ninja") Ninja ninja, @RequestParam("dojo_id") Long dojoId){
        Dojo dojo=apiServicio.getDojoById(dojoId);
        ninja.setDojo(dojo);
        apiServicio.saveNinja(ninja);
        return "redirect:/dojos/"+dojoId;
    }
}

