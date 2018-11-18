/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defiLecture.modele;

/**
 *
 * @author Sebas
 */
public class Reponses {
    private int id_compte, id_defi;
    private String reponse;

    /**
     * @return the id_compte
     */
    public int getId_compte() {
        return id_compte;
    }

    /**
     * @param id_compte the id_compte to set
     */
    public void setId_compte(int id_compte) {
        this.id_compte = id_compte;
    }

    /**
     * @return the id_defi
     */
    public int getId_defi() {
        return id_defi;
    }

    /**
     * @param id_defi the id_defi to set
     */
    public void setId_defi(int id_defi) {
        this.id_defi = id_defi;
    }

    /**
     * @return the reponse
     */
    public String getReponse() {
        return reponse;
    }

    /**
     * @param reponse the reponse to set
     */
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
}
