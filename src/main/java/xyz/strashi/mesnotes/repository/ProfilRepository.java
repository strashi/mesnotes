package xyz.strashi.mesnotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.strashi.mesnotes.model.Profil;

public interface ProfilRepository extends JpaRepository<Profil,Integer> {

    Profil findByUsername(String username);
}
