/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.Config;
import jdbc.Connexion;
import modele.Compte;
import modele.CompteDAO;
import modele.DefiDAO;
import modele.InscriptionDefiDAO;
import modele.Defi;
import modele.DemandeEquipe;
import modele.DemandeEquipeDAO;
import modele.InscriptionDefi;

/**
 *
 * @author Charles
 */
public class EffectuerInscriptionDefiAction implements Action, RequestAware, RequirePRGAction {

    private HttpServletRequest request;
    private HttpServletResponse response;

    
    
    
    @Override
    public String execute() {
        
        if(request.getParameter("valider")!=null){
            String reponseParticipant = request.getParameter("reponseParticipant");
            int     idCompte = Integer.parseInt(request.getParameter("idCompte")),
                    idDefi = Integer.parseInt(request.getParameter("idDefi"));
            InscriptionDefi inscriptionDefi = new InscriptionDefi();       
              
            try {
                Connection cnx = Connexion.startConnection(Config.DB_USER,Config.DB_PWD,Config.URL,Config.DRIVER);
                DefiDAO daoDefi = new DefiDAO(cnx);
                Defi defi = daoDefi.read(idDefi);
                
                
                if(defi == null)
                    return "*.do?tache=afficherPageParticipationDefi";
                else{
                    
                    //Si le participant a déjà fait le défi, on ne crée pas une nouvelle inscription_defi
                    cnx = Connexion.startConnection(Config.DB_USER,Config.DB_PWD,Config.URL,Config.DRIVER);
                    InscriptionDefiDAO daoInscriptionDefi = new InscriptionDefiDAO(cnx);
                    List<InscriptionDefi> listeInscriptionDefi = daoInscriptionDefi.findAllByIdCompte(idCompte);
                    for(InscriptionDefi i : listeInscriptionDefi){
                        if(i.getIdDefi() == idDefi)
                            return "*.do?tache=afficherPageParticipationDefi";
                    }
                
                
                    
                    cnx = Connexion.startConnection(Config.DB_USER,Config.DB_PWD,Config.URL,Config.DRIVER);
                    daoInscriptionDefi = new InscriptionDefiDAO(cnx);
                    
                    inscriptionDefi.setIdCompte(idCompte);
                    inscriptionDefi.setIdDefi(idDefi);
                    //On vérifie si la réponse du participant est la bonne réponse
                    //Si non, une inscription_defi est crée, avec le résultat 0 (échoué)
                    if(!defi.getReponse().equals(reponseParticipant)) {
                        
                        inscriptionDefi.setValeurMinute(0);
                        inscriptionDefi.setEstReussi(0);
                        
                        
                    }
                    //Si oui, une inscription_defi est crée, avec le résultat 1 (réussie)
                    else{
                        
                        inscriptionDefi.setValeurMinute(defi.getValeurMinute());
                        inscriptionDefi.setEstReussi(1);
                        
                        //Mise à jour des points du participant
                        //Conversion du nombre de minutes de la lecture en points pour le Participant : 15mins = 1 point
                        CompteDAO daoCompte = new CompteDAO(cnx);
                        Compte compte = new Compte();
                        compte = daoCompte.read(idCompte);
                        int pointDefi = (defi.getValeurMinute() + compte.getMinutesRestantes()) / 15;
                        int pointCompte = compte.getPoint() + pointDefi;
                        //Les minutes restantes sont gardées en mémoire ici
                        int minutesRestantes = (defi.getValeurMinute() + compte.getMinutesRestantes()) % 15;
                        compte.setPoint(pointCompte);
                        compte.setMinutesRestantes(minutesRestantes);
                        daoCompte.update(compte);
                        //Mise à jour des points dans demande_equipe (pour calculer le total des points de l'équipe)
                        if(compte.getIdEquipe() > 0){
                            DemandeEquipeDAO demandeDAO = new DemandeEquipeDAO(cnx);
                            DemandeEquipe demande = new DemandeEquipe();
                            demande = demandeDAO.findByIdCompteEquipe(idCompte, compte.getIdEquipe()).get(0);
                            int pointDemandeEquipe = demande.getPoint() + pointDefi;
                            demande.setPoint(pointDemandeEquipe);
                            demandeDAO.update(demande);
                        }
                
                    }
                    
                    //Création de l'inscription_defi dans la base de données
                    daoInscriptionDefi.create(inscriptionDefi);
                    return "*.do?tache=afficherPageParticipationDefi";
                    
                }
                    
                
                        
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EffectuerModificationCompteAction.class.getName()).log(Level.SEVERE, null, ex);
                return "*.do?tache=afficherPageParticipationDefi";
              }
            
        }
        else
            return "*.do?tache=afficherPageParticipationDefi";
        
        
        
    }

    @Override
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    @Override
    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


    
}
