package xyz.strashi.mesnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.strashi.mesnotes.model.Profil;
import xyz.strashi.mesnotes.service.ProfilService;

@Controller
public class LoginController {

    @Autowired
    private ProfilService profilService;

    @GetMapping("/login")
    public  String loginPage(){
        return "login";

    }

}
