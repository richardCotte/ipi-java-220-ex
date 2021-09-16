package com.exemple;

public class Client {
    String nom ;
    String prenom ;
    Integer numero ;

    Integer calculReduction(){
        if(this.numero < 200000){
            return 10;
        }
        return 0;
    }
}
