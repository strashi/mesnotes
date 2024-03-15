package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.dto.NoteDTO;
import xyz.strashi.mesnotes.model.Note;
import xyz.strashi.mesnotes.repository.NoteRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    public List<List<Note>> sortNote (String username) {
        List<Note> noteByUsername = noteRepository.findByUsername(username);
        List<String> matieres = new ArrayList<>();
        List<List<Note>> resultat = new ArrayList<>();

        for (Note note : noteByUsername) {
            String nomMatiere = note.getMatiere().getMatiere();
            if (!matieres.contains(nomMatiere)) {
                matieres.add(nomMatiere);
            }

        }
        for (String matiere : matieres) {

          List<Note> listNoteParMatiere = new ArrayList<>();

            for (Note note : noteByUsername) {

                if ((note.getMatiere().getMatiere()).equals(matiere)) {
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
}
