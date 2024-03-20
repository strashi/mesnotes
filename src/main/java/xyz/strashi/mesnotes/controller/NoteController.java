package xyz.strashi.mesnotes.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.strashi.mesnotes.model.Matiere;
import xyz.strashi.mesnotes.model.Note;
import xyz.strashi.mesnotes.model.Sortedetravail;
import xyz.strashi.mesnotes.service.MatiereService;
import xyz.strashi.mesnotes.service.NoteService;
import xyz.strashi.mesnotes.service.SortedetravailService;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class NoteController {

    @Autowired
    private MatiereService matiereService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private SortedetravailService sortedetravailService;



    @GetMapping("/")
    public String getNotes(Model model, HttpServletRequest request, Principal principal){
        boolean admin = false;
        if(request.isUserInRole("ROLE_ADMIN"))
            admin = true;
        model.addAttribute("admin", admin);

        model.addAttribute("principal",principal);

        Note note = new Note();
        note.setUsername(principal.getName());
        model.addAttribute("note",note);

        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres",matieres);

        List<Sortedetravail> sortes = sortedetravailService.findAll();
        model.addAttribute("sortes",sortes);

         List<Note> notes = noteService.getNotes();
         model.addAttribute("notes",notes);

         List<List<Note>> metaList = noteService.sortNote(principal.getName());
         model.addAttribute("metaList", metaList);

         return "notes";
    }

    @GetMapping("/updateNote/{id}")
    public String updateNote(@PathVariable("id") Integer id, Model model){
        Note note = noteService.findById(id);
        model.addAttribute("note",note);

        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres",matieres);

        List<Sortedetravail> sortes = sortedetravailService.findAll();
        model.addAttribute("sortes",sortes);
        return "updateNote";
    }

    @PostMapping("/updateNote/{id}")
    public String updateNote(@PathVariable("id") Integer id, Note note){
        note.setId_note(id);
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") Integer id){

        noteService.deleteById(id);
        return ("redirect:/");
    }




/*    @GetMapping("/nouvelleNote")
    public String getNouvelleNote(Principal principal, Model model){
        Note note = new Note();
        note.setUsername(principal.getName());
        model.addAttribute("note",note);

        model.addAttribute("principal",principal);

        List<Matiere> matieres = matiereService.findAll();
        model.addAttribute("matieres",matieres);

        List<Sortedetravail> sortes = sortedetravailService.findAll();
        model.addAttribute("sortes",sortes);
        return "nouvelleNote";
    }*/

    @PostMapping("/nouvelleNote")
    public String postNouvelleNote(Note note){
        noteService.save(note);
        return "redirect:/";
    }

}
