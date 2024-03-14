package xyz.strashi.mesnotes.model;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "profils")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profil")
    private Integer id_profil;
    @Column(name = "identifiant")
    private String identifiant;
    @Column(name = "motdepasse")
    private String motdepasse;
    @Column(name = "role")
    private String role;

    public Integer getId_profil() {
        return id_profil;
    }

    public void setId_profil(Integer id_profil) {
        this.id_profil = id_profil;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
