package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Sortedetravail;
import xyz.strashi.mesnotes.repository.SortedetravailRepository;

import java.util.List;

@Service
public class SortedetravailService {

    @Autowired
    private SortedetravailRepository sortedetravailRepository;

    public List<Sortedetravail> findAll(){
        return sortedetravailRepository.findAll();
    }

    public void deleteSorte(Integer id) {
        sortedetravailRepository.deleteById(id);
    }

    public void addSorte(String nomSorte) {
        Sortedetravail sortedetravail = new Sortedetravail();
        sortedetravail.setSorte(nomSorte);
        sortedetravailRepository.save(sortedetravail);
    }
}
