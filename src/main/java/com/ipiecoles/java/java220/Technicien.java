package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe {

    private Integer grade;

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (grade / 10d + 1));
    }

    @Override
    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE + getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * (grade / 10d + 1) +
                Entreprise.PRIME_ANCIENNETE * getNombreAnneeAnciennete();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
