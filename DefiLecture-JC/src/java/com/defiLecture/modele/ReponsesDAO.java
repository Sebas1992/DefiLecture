
package com.defiLecture.modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.Connexion;

public class ReponsesDAO {
    public List<Reponses> findByDefi(Defi defi)
    {
        
        String requete = "SELECT * FROM reponses WHERE ID_DEFI = ?";
        List<Reponses> listeRep = new LinkedList();
        
         try {
            Connection cnx = Connexion.getInstance();
            PreparedStatement stm = cnx.prepareStatement(requete);            
            
            stm.setInt(1, defi.getIdDefi());
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next())
            {
                Reponses rep = new Reponses();
                rep.setId_compte(rs.getInt("id_compte"));
                rep.setId_defi(rs.getInt("id_defi"));
                rep.setReponse(rs.getString("reponse"));
                rep.setCorrect(rs.getBoolean("correct"));
                listeRep.add(rep);
            }
            return listeRep;
        } catch (SQLException ex) {
            Logger.getLogger(ReponsesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return listeRep;
    }
    
    public boolean updateIsCorrect(int id, boolean value)
    {
        String request = "UPDATE reponses SET correct = ? WHERE id_compte = ?";
        int rowsAffected = 0;
        
        Connection cnx;
        try {
            cnx = Connexion.getInstance();
            PreparedStatement stm = cnx.prepareStatement(request);
            stm.setBoolean(1, value);
            stm.setInt(2, id);
            
            rowsAffected = stm.executeUpdate();
            return rowsAffected != 0;
        } catch (SQLException ex) {
            Logger.getLogger(ReponsesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected != 0;
    }
}
