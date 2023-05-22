package com.balmes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursId;
    private String titolCurs;
    private String descCurs;
    private String urlCurs;

    /**name = "curs_estudiant",
            joinColumns = @JoinColumn(name = "estudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "curs_id"))**/
    @OneToMany(mappedBy = "curs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiant> estudiants;

    public Curs() {
    }

    public Long getCursId() {
        return cursId;
    }

    public void setCursId(Long cursId) {
        this.cursId = cursId;
    }

    public String getTitolCurs() {
        return titolCurs;
    }

    public void setTitolCurs(String titolCurs) {
        this.titolCurs = titolCurs;
    }

    public String getDescCurs() {
        return descCurs;
    }

    public void setDescCurs(String descCurs) {
        this.descCurs = descCurs;
    }

    public String getUrlCurs() {
        return urlCurs;
    }

    public void setUrlCurs(String urlCurs) {
        this.urlCurs = urlCurs;
    }


    public List<Estudiant> getEstudiants() {
        return estudiants;
    }

    public void setEstudiants(List<Estudiant> estudiants) {
        this.estudiants = estudiants;
    }
}
