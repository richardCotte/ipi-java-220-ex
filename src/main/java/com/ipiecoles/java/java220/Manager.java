package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<>();

    public void ajoutTechnicienEquipe(Technicien mbrEquipe){
        equipe.add(mbrEquipe);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate date, Double salaire, Integer grade) {
        Technicien mbrEquipe = new Technicien(nom, prenom, matricule, date, salaire, grade);
        equipe.add(mbrEquipe);
    }

    private void augmenterSalaireEquipe(Double augPercent) throws Exception {
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(augPercent);
        }
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    @Override
    public void augmenterSalaire(Double augPercent) throws Exception {
        augmenterSalaireEquipe(augPercent);
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * Entreprise.INDICE_MANAGER +
                salaire * 0.1 * equipe.size());
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + Entreprise.PRIME_MANAGER_PAR_TECHNICIEN * equipe.size();
    }
}
