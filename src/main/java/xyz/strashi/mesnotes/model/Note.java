package xyz.strashi.mesnotes.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Integer id_note;
    @Column(name = "resultat")
    private String resultat;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "commentaire")
    private String commentaire;

    /*@ManyToOne
    @JoinColumn(name = "id_profil")
    private Profil profil;*/
    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
/* public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }*/

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Sortedetravail getSorte() {
        return sorte;
    }

    public void setSorte(Sortedetravail sorte) {
        this.sorte = sorte;
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;
    @ManyToOne
    @JoinColumn(name = "id_sorte")
    private Sortedetravail sorte;

    public Integer getId_note() {
        return id_note;
    }

    public void setId_note(Integer id_note) {
        this.id_note = id_note;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id_note=" + id_note +
                ", resultat='" + resultat + '\'' +
                ", date=" + date +
                ", commentaire='" + commentaire + '\'' +
                ", username=" + username +
                ", matiere=" + matiere +
                ", sorte=" + sorte +
                '}';
    }
}
