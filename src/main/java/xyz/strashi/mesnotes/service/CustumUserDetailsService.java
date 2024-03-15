package xyz.strashi.mesnotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.strashi.mesnotes.model.Profil;
import xyz.strashi.mesnotes.repository.ProfilRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustumUserDetailsService implements UserDetailsService {

    @Autowired
    private ProfilRepository profilRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profil profil = profilRepository.findByUsername(username);
        return new User(profil.getUsername(),profil.getPassword(),getGrantedAuthorities(profil.getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
}
