/**
    This file is part of DefiLecture.

    DefiLecture is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    DefiLecture is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DefiLecture.  If not, see <http://www.gnu.org/licenses/>.
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defiLecture.modele;

/**
 *
 * @author Joel
 */
public class Compte {
    public static int PARTICIPANT    = 1;
    public static int CAPITAINE      = 2;
    public static int MODERATEUR     = 3;
    public static int ADMINISTRATEUR = 4;
    public static String AVATAR_DEFAUT ="/images/avatars/avatarCompte_defaut.png";
       
    private int idCompte,                       //clé primaire
                idEquipe =-1;                   //équipe dont le participant fait partie -1:le compte en question ne fait pas partie d'une équipe
    
    private int role = Compte.PARTICIPANT,      //Utilisateur==0 | Participant==1 | Capitaine==2 | Animateur==3 | Administrateur==4
                point,                          //Sommes des points gagnées par les lectures. 
                minutesRestantes,
                devenirCapitaine;               //Utilisateur veut devenir capitaine = 1 sinon, 0.

    public int getDevenirCapitaine() {
        return devenirCapitaine;
    }

    public void setDevenirCapitaine(int devenirCapitaine) {
        this.devenirCapitaine = devenirCapitaine;
    }
   

//    String nomUtilisateur;                    //ancienne clé primaire
    private String pseudonyme,                  //l'utilisateur peut aussi s'inscrire avec un pseudo unique
                   nom,
                   prenom,
                   courriel,
                   motPasse,
                   programmeEtude,              //programme scolaire
                   avatar = AVATAR_DEFAUT;      //Pour l'instant l'avatar sera représenté par le chemin vers l'image
    
    public Compte(){
    
    }

    public Compte(int idCompte, int idEquipe, String pseudonyme, String nom, String prenom,
                            String courriel, String programme, String avatar, int role, int pointage, int minutesRestantes) {
        this.idCompte = idCompte;
        this.idEquipe = idEquipe;
        this.pseudonyme = pseudonyme;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.programmeEtude = programme;
        this.avatar = avatar;
        this.role = role;
        this.point = pointage;
        this.minutesRestantes = minutesRestantes;
    }

    public Compte(int idEquipe, String pseudonyme, String nom, String prenom, String courriel,
                            String programme, String avatar, int role, int pointage, int minutesRestantes) {
        this.idEquipe = idEquipe;
        this.pseudonyme = pseudonyme;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.programmeEtude = programme;
        this.avatar = avatar;
        this.role = role;
        this.point = pointage;
        this.minutesRestantes = minutesRestantes;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public int getMinutesRestantes() {
        return minutesRestantes;
    }

    public void setMinutesRestantes(int minutesRestantes) {
        this.minutesRestantes = minutesRestantes;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }

    public void setPseudonyme(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getProgrammeEtude() {
        return programmeEtude;
    }

    public void setProgrammeEtude(String programmeEtude) {
        this.programmeEtude = programmeEtude;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
       
    
}
