package xyz.strashi.mesnotes.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Integer id_note;
    @Column(name = "note")
    private String note;
    @Column(name = "date")
    private Date date;
    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "id_profil")
    private Profil profil;

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

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

    @ManyToOne
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                ", note='" + note + '\'' +
                ", date=" + date +
                ", commentaire='" + commentaire + '\'' +
                ", profil=" + profil +
                ", matiere=" + matiere +
                ", sorte=" + sorte +
                '}';
    }
}
