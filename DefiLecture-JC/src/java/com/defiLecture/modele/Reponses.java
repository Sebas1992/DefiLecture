
package com.defiLecture.modele;


public class Reponses {
    private int id_compte, id_defi;
    private String reponse;
    private boolean correct;


    public int getId_compte() {
        return id_compte;
    }


    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }


    public int getId_defi() {
        return id_defi;
    }


    public void setId_defi(int id_defi) {
        this.id_defi = id_defi;
    }


    public String getReponse() {
        return reponse;
    }


    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
