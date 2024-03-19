package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Matiere;
import xyz.strashi.mesnotes.repository.MatiereRepository;

import java.util.*;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;

    public List<Matiere> findAll() {
        List<Matiere> matieres = matiereRepository.findAll();
        matieres.sort(new Comparator<Matiere>() {
            @Override
            public int compare(Matiere o1, Matiere o2) {
                return o1.getNomMatiere().compareTo(o2.getNomMatiere());
            }
        });
       return matieres;

    }

    public void deleteMatiere(Integer id) {
        matiereRepository.deleteById(id);
    }

    public void addMatiere(String nomMatiere) {
        Matiere matiere = new Matiere();
        matiere.setNomMatiere(nomMatiere);
        matiereRepository.save(matiere);
    }

    public void updateMatiere(Matiere matiere) {
        matiereRepository.save(matiere);

    }

    public Optional<Matiere> findById(Integer id) {
       return matiereRepository.findById(id);
    }
}
