package com.balmes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudiantId;
    private String estudiantNom;
    private String estudiantCognom;

    //@ManyToMany
    @ManyToOne
    @JoinColumn(name = "curs_cursId")
    private Curs curs;

    public Estudiant() {
    }

    public Long getEstudiantId() {
        return estudiantId;
    }

    public void setEstudiantId(Long estudiantId) {
        this.estudiantId = estudiantId;
    }

    public String getEstudiantNom() {
        return estudiantNom;
    }

    public void setEstudiantNom(String estudiantNom) {
        this.estudiantNom = estudiantNom;
    }

    public String getEstudiantCognom() {
        return estudiantCognom;
    }

    public void setEstudiantCognom(String estudiantCognom) {
        this.estudiantCognom = estudiantCognom;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Estudiant{" +
                "estudiantId=" + estudiantId +
                ", estudiantNom='" + estudiantNom + '\'' +
                ", estudiantCognom='" + estudiantCognom + '\'' +
                ", curs=" + curs +
                '}';
    }
}
