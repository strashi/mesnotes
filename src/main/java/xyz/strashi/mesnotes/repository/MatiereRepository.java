package xyz.strashi.mesnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.strashi.mesnotes.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere,Integer> {
}
