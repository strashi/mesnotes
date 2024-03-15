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
}
