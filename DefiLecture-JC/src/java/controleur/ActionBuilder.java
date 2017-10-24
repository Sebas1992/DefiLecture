/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


/**
 *
 * @authors Charles & Joel
 */
public class ActionBuilder {
    public static Action getAction(String actionName) {
        System.out.print("entrer dans l'action builder");
        if (actionName != null)
            switch (actionName) {
                
                case "afficherPageAccueil":
                    return new AfficherPageAccueilAction();
                case "afficherPageEquipe":
                    return new AfficherPageEquipeAction();
                case "afficherPageProfil":
                    return new AfficherPageProfilAction();
       //Inscription
                case "afficherPageInscription":
                    return new AfficherPageInscriptionAction(); 
                case "effectuerInscription":
                    return new EffectuerInscriptionAction();  
       //Connexion
                case "afficherPageConnexion":
                    return new AfficherPageConnexionAction();    
                case "effectuerConnexion":
                    return new EffectuerConnexionAction();
                case "effectuerDeconnexion":
                    return new EffectuerDeconnexionAction();
       //Lecture             
                case "afficherCreationLecture":
                    return new AfficherCreationLectureAction();
                case "effectuerCreationLecture":
                    return new EffectuerCreationLectureAction();
                case "afficherPageModificationLecture":
                    return new AfficherPageModificationLectureAction();
                case "effectuerModificationLecture":
                    return new EffectuerModificationLectureAction();
       //Defi
                case "afficherCreationDefi":
                    return new AfficherCreationDefiAction();
                case "effectuerCreationDefi":
                    return new EffectuerCreationDefiAction();
       //Compte        
                case "afficherPageGestionListeCompte":
                    return new AfficherPageGestionListeComptesAction();
                case "afficherPageGestionConfigurationCompte":
                    return new AfficherPageGestionConfigurationCompteAction();
                case "effectuerModificationCompte":
                    return new EffectuerModificationCompteAction();

                    /*
                     
                case "effectuerCreationLecture":
                    return new EffectuerCreationLectureAction();                
                */
            }
        return new AfficherPageAccueilAction();
    }
}
