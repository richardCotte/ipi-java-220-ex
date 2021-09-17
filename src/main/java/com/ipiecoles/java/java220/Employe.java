package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

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
        int anneeAnciennete = 0;

        if(dateEmbauche.getYear() < LocalDate.now().getYear()){
            anneeAnciennete = LocalDate.now().getYear() - dateEmbauche.getYear();
        }

        return anneeAnciennete;
    }

    public void augmenterSalaire(Double augPercent) throws Exception {
        if(this.salaire == null) {
            throw new Exception("Le salaire ne peut être null");
        }
        if(augPercent < 0) {
            throw new Exception("Le pourcentage d'augmentation ne peut être inférieur à 0");
        }
        this.salaire = this.salaire * (1 + augPercent) ;
    }

    public Double getPrimeAnnuelle() { return Entreprise.primeAnnuelleBase(); }

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
        //si le paramètre est une date antèrieure ou égale a la date courante
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() { return salaire; }
    public void setSalaire(Double salaire) { this.salaire = salaire; }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' + ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) && Objects.equals(prenom, employe.prenom) && Objects.equals(matricule, employe.matricule) && Objects.equals(dateEmbauche, employe.dateEmbauche) && Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }
}
