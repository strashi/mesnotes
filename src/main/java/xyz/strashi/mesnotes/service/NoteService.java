package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.dto.NoteDTO;
import xyz.strashi.mesnotes.model.Note;
import xyz.strashi.mesnotes.repository.NoteRepository;

import java.util.*;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    public List<List<Note>> sortNote (String username) {
        List<Note> noteByUsername = noteRepository.findByUsername(username);
       /* List<Note> noteByUsername = noteRepository.findByUsernameJPQL(username);*/
        List<String> matieres = new ArrayList<>();
        Set<String> setMatieres = new TreeSet<>();
        List<List<Note>> resultat = new ArrayList<>();

        for (Note note : noteByUsername) {
            String nomMatiere = note.getMatiere().getNomMatiere();
          /*  if (!matieres.contains(nomMatiere)) {
                matieres.add(nomMatiere);
            }*/
            if (!setMatieres.contains(nomMatiere)){
                setMatieres.add(nomMatiere);
            }

        }
      /*  System.out.println(matieres);*/
       /* System.out.println(setMatieres);*/
     /*   for (String matiere : matieres) {

          List<Note> listNoteParMatiere = new ArrayList<>();

            for (Note note : noteByUsername) {

                if ((note.getMatiere().getMatiere()).equals(matiere)) {
                   listNoteParMatiere.add(note);


                }
            }
            resultat.add(listNoteParMatiere);

        }*/
        for (String matiere : setMatieres){
            List<Note> listNoteParMatiere = new ArrayList<>();

            for (Note note : noteByUsername) {

                if ((note.getMatiere().getNomMatiere()).equals(matiere)) {
                    listNoteParMatiere.add(note);


                }
            }
            resultat.add(listNoteParMatiere);

        }


        return resultat;
    }

    public void save(Note note){
        noteRepository.save(note);
    }

    public Note findById(Integer id) {
        Optional<Note> opt = noteRepository.findById(id);
        Note note = opt.get();
        return note;
    }

    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }
}
