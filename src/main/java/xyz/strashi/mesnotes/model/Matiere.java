package xyz.strashi.mesnotes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matieres")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matiere")
    private Integer id_matiere;
    @Column(name = "matiere")
    private String matiere;

    public Integer getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(Integer id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
