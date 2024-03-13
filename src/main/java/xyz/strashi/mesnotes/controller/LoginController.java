package xyz.strashi.mesnotes.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.strashi.mesnotes.model.Matiere;
import xyz.strashi.mesnotes.service.MatiereService;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private MatiereService matiereService;

    @GetMapping("/")
    public String getNotes(Model model, HttpServletRequest request){
        boolean admin = false;
        if(request.isUserInRole("ROLE_ADMIN"))
            admin = true;
        model.addAttribute("admin", admin);

        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres",matieres);
        return "notes";
    }
}
