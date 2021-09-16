package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */


public class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe(){

    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete(){
        Integer anneeAnciennete = 0;

        if(dateEmbauche.getYear() < LocalDate.now().getYear()){
            anneeAnciennete = LocalDate.now().getYear() - dateEmbauche.getYear();
        }

        return anneeAnciennete;
    }

    public Integer getNbConges() { return Entreprise.NB_CONGES_BASE; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public LocalDate getDateEmbauche() { return dateEmbauche; }
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if(dateEmbauche == null){
            throw new Exception("La date d'embauche ne peut pas être nulle");
        }
        if(dateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
            this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() { return salaire; }
    public void setSalaire(Double salaire) { this.salaire = salaire; }
}
