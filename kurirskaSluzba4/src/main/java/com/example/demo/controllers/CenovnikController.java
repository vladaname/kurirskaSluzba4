package com.example.demo.controllers;

import com.example.demo.dto.CenovnikDTO;
import com.example.demo.model.Cenovnik;
import com.example.demo.model.Osoba;
import com.example.demo.service.CenovnikService;
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

@Controller
public class CenovnikController {
    @Autowired
    CenovnikService cenovnikService;

    @GetMapping("/createCenovnik")
    public ModelAndView createCenovnikGET(){
        return new ModelAndView("createCenovnik", "cenovnikDTO", new CenovnikDTO());
    }

    @PostMapping("/createCenovnik")
    public String createCenovnikPOST(Model model, @ModelAttribute("cenovnikDTO") CenovnikDTO cenovnikDTO, HttpServletRequest request,
                                     RedirectAttributes redirectAttributes){
       // Osoba o = (Osoba) request.getSession().getAttribute("dispecher");
        Cenovnik c = cenovnikService.createCenovnik(cenovnikDTO);
        if(c != null){
//            List<Cenovnik> listaCenovnika = cenovnikService.listaCena();
//            model.addAttribute("cenovnikLista", listaCenovnika);
            return "redirect:/cenovnik";
        }
        else{
            return "redirect:/createCenovnik";
        }
    }
    @GetMapping("/cenovnik")
    public String cenovnikGET(Model model, HttpServletRequest request){
  //      List<Cenovnik> listaCenovnika = cenovnikService.listaCena();
        Cenovnik c = cenovnikService.findTopByOrderByIdCenovnikDesc();
 //       List<Cenovnik> c = cenovnikService.findTopByOrderByIdCenovnikDesc();

        model.addAttribute("cenovnik", c);
        return "cenovnik";
    }
}
