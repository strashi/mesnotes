package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Profil;
import xyz.strashi.mesnotes.repository.ProfilRepository;

@Service
public class ProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void save(Profil profil){
       /* String password = profil.getPassword();
        String hashPassword = passwordEncoder.encode(password);
        profil.setPassword(hashPassword);*/
        profil.setPassword(passwordEncoder.encode(profil.getPassword()));
        profilRepository.save(profil);
    }
}
