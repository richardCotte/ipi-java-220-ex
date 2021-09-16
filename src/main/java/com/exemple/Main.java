package com.exemple;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        String maChaine = "oui";
        System.out.println(maChaine);

        maChaine = "Au revoir";
        System.out.println(maChaine);

        maChaine = null ;
        System.out.println(maChaine);

        Client c, c2;

        c = new Client();
        c2 = new Client();

        c.nom = "Cotte";
        c.prenom = "Richard";
        c.numero = 123456;

        c2.nom = "Dubuc";
        c2.prenom = "Lola";
        c2.numero = 654321;

        out.println("Nom C : " + c.nom);
        out.println("Prénom C : " + c.prenom);
        out.println("Numéro C : " + c.numero);
        out.println("Réduction C : " + c.calculReduction() + " %");

        out.println() ;

        out.println("Nom C2 : " + c2.nom);
        out.println("Prénom C2 : " + c2.prenom);
        out.println("Numéro C2 : " + c2.numero);
        out.println("Réduction C2 : " + c2.calculReduction() + " %");
    }
}
