package xyz.strashi.mesnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.strashi.mesnotes.model.Matiere;
import xyz.strashi.mesnotes.model.Profil;
import xyz.strashi.mesnotes.model.Sortedetravail;
import xyz.strashi.mesnotes.service.MatiereService;
import xyz.strashi.mesnotes.service.ProfilService;
import xyz.strashi.mesnotes.service.SortedetravailService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProfilService profilService;

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private SortedetravailService sortedetravailService;

    @GetMapping("/admin")
    public String getAdmin(Model model){

        List<Profil> profils = profilService.findAll();
        model.addAttribute("profils", profils);

        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres", matieres);

        List<Sortedetravail> sortes = sortedetravailService.findAll();
        model.addAttribute("sortes", sortes);



        return "admin";
    }

    @GetMapping("/admin/deleteProfil/{id}")
    public String deleteProfil(@PathVariable("id") Integer id){
        profilService.deleteProfil(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleteMatiere/{id}")
    public String deleteMatiere(@PathVariable("id") Integer id){
        matiereService.deleteMatiere(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleteSorte/{id}")
    public String deleteSorte(@PathVariable("id") Integer id){
        sortedetravailService.deleteSorte(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/ajouterMatiere")
    public String ajouterMatiere(String nomMatiere){
        matiereService.addMatiere(nomMatiere);
        return "redirect:/admin";
    }

    @PostMapping("/admin/ajouterSorte")
    public String ajouterSorte(String nomSorte){
        sortedetravailService.addSorte(nomSorte);
        return "redirect:/admin";
    }
}
