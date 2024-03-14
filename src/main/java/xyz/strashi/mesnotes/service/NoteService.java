package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.dto.NoteDTO;
import xyz.strashi.mesnotes.model.Note;
import xyz.strashi.mesnotes.repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes(){
        return noteRepository.findAll();
    }
}
