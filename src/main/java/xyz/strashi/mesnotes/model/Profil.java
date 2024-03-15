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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public Integer getId_profil() {
        return id_profil;
    }

    public void setId_profil(Integer id_profil) {
        this.id_profil = id_profil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
