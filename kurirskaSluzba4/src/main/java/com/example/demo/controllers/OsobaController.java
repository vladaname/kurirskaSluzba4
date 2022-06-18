package com.example.demo.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.dto.OsobaDTO;
import com.example.demo.model.Osoba;
import com.example.demo.service.OsobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OsobaController {

    @Autowired
    OsobaService osobaService;

    @GetMapping("/createOsoba")
    public ModelAndView createOsoba(){

        return new ModelAndView("createOsoba", "osobaDTO", new OsobaDTO());
    }

    @PostMapping("/createOsoba")
    public String createOsobaPOST(Model model, @ModelAttribute("osobaDTO") OsobaDTO osobaDTO){

        boolean b = osobaService.createOsoba(osobaDTO);

        if(b){
            model.addAttribute("poruka", "Osoba je kreirana");
            return "login";
        }
        else{
            model.addAttribute("poruka", "Greska.");
            return "createOsoba";
        }
    }

    @GetMapping("/login")
    public ModelAndView loginGET()
    {
       return new ModelAndView("login", "osobaDTO", new OsobaDTO());
    }
    @PostMapping("/login")
    public String loginPOST(Model model, @ModelAttribute("osobaDTO") OsobaDTO osobaDTO, HttpServletRequest request,
                            RedirectAttributes redirect){
        Osoba login = osobaService.login(osobaDTO);
        if(login != null){
            request.getSession().setAttribute("korisnik", login);

            return "redirect:/createPosiljka";
        }
        else{
            model.addAttribute("poruka", "Greska. Pokusajte ponovo.");
            return "login";
        }

    }
}
