package xyz.strashi.mesnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.strashi.mesnotes.model.Note;

import java.util.List;
@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {

   /* List<Note> findByUsername(String username);*/

    @Query("FROM Note WHERE username = ?1 ORDER BY date DESC")
    List<Note> findByUsername(String username);
}
