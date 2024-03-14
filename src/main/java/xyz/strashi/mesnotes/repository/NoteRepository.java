package xyz.strashi.mesnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.strashi.mesnotes.model.Note;

public interface NoteRepository extends JpaRepository<Note,Integer> {
}
