package xyz.strashi.mesnotes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sortesdetravail")
public class Sortedetravail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sorte")
    private Integer id_sorte;
    @Column(name = "sorte")
    private String sorte;

    public Integer getId_sorte() {
        return id_sorte;
    }

    public void setId_sorte(Integer id_sorte) {
        this.id_sorte = id_sorte;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
        this.sorte = sorte;
    }
}
