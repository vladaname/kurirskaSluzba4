package com.example.demo.controllers;

import com.example.demo.dto.PosiljkaDTO;
import com.example.demo.dto.PromeniStatusDTO;
import com.example.demo.model.Osoba;
import com.example.demo.model.Posiljka;
import com.example.demo.model.Racun;
import com.example.demo.service.PosiljkaService;
import com.example.demo.service.RacunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class PosiljkaController {

    @Autowired
    PosiljkaService posiljkaService;

    @GetMapping("/createPosiljka")
    public ModelAndView createPosiljkaGET() {
        return new ModelAndView("createPosiljka", "posiljkaDTO", new PosiljkaDTO());
    }

    @PostMapping("/createPosiljka")
    public String createPosiljkaPOST(Model model, @ModelAttribute("posiljkaDTO") PosiljkaDTO posiljkaDTO, HttpServletRequest request) {
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        //       Map.Entry<Posiljka, Integer> p = posiljkaService.createPosiljka(posiljkaDTO, o.getIdOsoba());
        Racun r = posiljkaService.createPosiljka(posiljkaDTO, o.getIdOsoba());

        if (r != null) {

            model.addAttribute("poruka", "Posiljka je kreirana.");
            //           model.addAttribute("sifraPosiljke", p.getKey().getSifraPosiljke());
            //           model.addAttribute("ukupanRacun", p.getValue());
            model.addAttribute("sifraPosiljke", r.getPosiljka().getSifraPosiljke());
            model.addAttribute("ukupanRacun", r.getUkupanRacun());
            return "poslataPosiljka";
        } else {
            model.addAttribute("poruka", "Greska. Pokusajte ponovo.");

            return "createPosiljka";
        }
    }

    @GetMapping("/listaPosiljki")
    public String getPosiljkaList(Model model, HttpServletRequest request) {
        Osoba o = (Osoba) request.getSession().getAttribute("korisnik");
        if (o != null) {
            List<Posiljka> posiljkaList = posiljkaService.getListaPisiljki(o.getIdOsoba());
            model.addAttribute("listaPosiljki", posiljkaList);
        }
        else {
            model.addAttribute("poruka", "Greska");

        }
        return "listaPosiljki";

    }

    @GetMapping("/listaSvihPosiljki")
    public String getSvePosiljke(Model model){
            List<Posiljka> getSvePosiljke = posiljkaService.getSvePosiljke();
            if(getSvePosiljke != null){
                model.addAttribute("svePosiljke", getSvePosiljke);
                model.addAttribute("promeniStatusDTO", new PromeniStatusDTO());//zasto se ovako radi?
            }
            else{
                model.addAttribute("poruka", "Greska");
            }

        return "svePosiljke";

    }
        @PostMapping("/promeniStatus")
    public String promeniStatusPosiljke(Model model, @ModelAttribute("PromeniStatusDTO") PromeniStatusDTO promeniStatusDTO,
                                 RedirectAttributes redirectAttributes){
        boolean promeniStatus = posiljkaService.promeniStatus(promeniStatusDTO.getIdPosiljka());
        if(promeniStatus){
            model.addAttribute("poruka", "Uspesno promenjeno");
        }
        else{
            model.addAttribute("poruka", "Greska");
        }
        return "redirect:/listaSvihPosiljki";
        }





}
