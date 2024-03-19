package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Sortedetravail;
import xyz.strashi.mesnotes.repository.SortedetravailRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SortedetravailService {

    @Autowired
    private SortedetravailRepository sortedetravailRepository;

    public List<Sortedetravail> findAll(){
        List<Sortedetravail> sortes = sortedetravailRepository.findAll();
        sortes.sort(new Comparator<Sortedetravail>() {
            @Override
            public int compare(Sortedetravail o1, Sortedetravail o2) {

                return o1.getSorte().compareTo(o2.getSorte());
            }
        });
        return sortes;
    }

    public void deleteSorte(Integer id) {
        sortedetravailRepository.deleteById(id);
    }

    public void addSorte(String nomSorte) {
        Sortedetravail sortedetravail = new Sortedetravail();
        sortedetravail.setSorte(nomSorte);
        sortedetravailRepository.save(sortedetravail);
    }

    public void updateSorte(Sortedetravail sortedetravail) {
        sortedetravailRepository.save(sortedetravail);
    }

    public Sortedetravail findById(Integer id) {
        Optional<Sortedetravail> opt = sortedetravailRepository.findById(id);
        Sortedetravail sortedetravail = opt.get();
        return sortedetravail;
    }
}
