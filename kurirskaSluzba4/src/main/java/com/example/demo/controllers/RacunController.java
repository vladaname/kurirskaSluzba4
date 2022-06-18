package com.example.demo.controllers;

import com.example.demo.dto.RacunDTO;
import com.example.demo.model.Osoba;
import com.example.demo.model.Racun;
import com.example.demo.service.RacunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RacunController {

    @Autowired
    RacunService racunService;

    @GetMapping("/createRacun")
    public String createRacun(HttpServletRequest request, Model model, @ModelAttribute("createRacun") RacunDTO racunDTO,
    RedirectAttributes redirectAttributes){
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        Racun r = racunService.createRacun(o.getIdOsoba());
        if(r != null){
            model.addAttribute("racun", r.getUkupanRacun());
            return "redirect:/racun";
        }
        else{
            return "createPosiljka";
        }

    }

}
