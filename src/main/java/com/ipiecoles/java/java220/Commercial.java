package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {
    private Double caAnnuel;
    private Integer performance;

    public Commercial() {
    }

    public Commercial(String nom, String prenom, String matricule,
                      LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule,
                      LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Boolean performanceEgale(Integer perfTest) {
        if(performance.equals(perfTest)){
            return true ;
        }
        return false ;
    }

    @Override
    public Double getPrimeAnnuelle(){
        if(caAnnuel == null || caAnnuel * 0.05 <= 500){
            return 500.0;
        }
        return Math.ceil(caAnnuel * 0.05) ;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel) && Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }
}
