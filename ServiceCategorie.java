/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.services;




import edu.huntkingdom.entities.categorie;
import edu.huntkingdom.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ServiceCategorie {
    
    private Connection con;
    private Statement ste;

    public ServiceCategorie() {
        con = DataBase.getInstance().getConnection();
    }

    public List<categorie> readAll() {

        List<categorie> arr = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select * from categorie ");
            while (rs.next()) {
                //int id=rs.getInt(1);
                int id = rs.getInt("idcat");
                String nomcat = rs.getString("nomcat");
                

                categorie c = new categorie(id,nomcat);
                arr.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

   /* public void ajoutcategorie(categorie c) {
        try {

            ste = con.createStatement();
            String requeteInsert = "INSERT INTO categorie (nomcat) VALUES (?)";

            PreparedStatement pst = con.prepareStatement(requeteInsert);
            pst.setString(1, c.getNomcat());
            

 if (pst.executeUpdate() != 0) {
                System.out.println("categorie deleted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    */

public categorie findbyid(int idcat) {
        categorie c = new categorie();
        try {

            PreparedStatement pre = con.prepareStatement("Select * from categorie  WHERE idcat=? ");
            pre.setInt(1, idcat);
            ResultSet rs = pre.executeQuery();//hedhi ki taffichi
            while (rs.next()) {
               
                String nomcat = rs.getString("nomcat");
            
            
            
          c.setNomcat(nomcat);
             
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return c;
    }


 public boolean supprimer(categorie c) throws SQLException {

        String reqeute = "delete from categorie  where (idcat = ?) ;";
        try {
            PreparedStatement pst = con.prepareStatement(reqeute);
            pst.setInt(1, c.getIdcat());
            // pst.setString(2, m.setDescription(reqeute));
            if (pst.executeUpdate() != 0) {
                System.out.println("");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return false;

}
 
public void ajouterEvent(categorie c)   {
       

        try {
            ste = con.createStatement();
            String requeteInsert = "INSERT INTO categorie (idcat,nomcat) VALUES (?,?)";

            PreparedStatement pst = con.prepareStatement(requeteInsert);
            pst.setInt(1, c.getIdcat());
            pst.setString(2, c.getNomcat());
            
            pst.executeUpdate(); 
        } catch (SQLException ex) {
ex.printStackTrace();
        }
           

    }
    

}

