package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Matiere;
import xyz.strashi.mesnotes.repository.MatiereRepository;

import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    public void deleteMatiere(Integer id) {
        matiereRepository.deleteById(id);
    }

    public void addMatiere(String nomMatiere) {
        Matiere matiere = new Matiere();
        matiere.setMatiere(nomMatiere);
        matiereRepository.save(matiere);
    }
}
