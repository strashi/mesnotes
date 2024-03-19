package xyz.strashi.mesnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.strashi.mesnotes.model.Matiere;

import java.util.Set;
import java.util.TreeSet;

public interface MatiereRepository extends JpaRepository<Matiere,Integer> {


}
