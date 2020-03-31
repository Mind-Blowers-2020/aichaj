/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.services;

import edu.huntkingdom.entities.produit;
import edu.huntkingdom.entities.categorie;
import edu.huntkingdom.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Serviceproduit {
   
    
 private Connection con;
    private Statement ste;

    public Serviceproduit() {
        con = DataBase.getInstance().getConnection();
    }

    public List<produit> readAll() {

        List<produit> arr = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select * from produit ");
            while (rs.next()) {
                //int id=rs.getInt(1);
                int idP = rs.getInt("idP");
                String nomprod = rs.getString("nomprod");
                int qt = rs.getInt("qt");
                Double prix = rs.getDouble("prix");
                String description = rs.getString("description");
                String image = rs.getString("image");
                int idcat = rs.getInt("idcat");
 
                produit p = new produit(idP, nomprod, prix,qt,  description, image, idcat);
                arr.add(p);

            }
        } catch (SQLException ex) {
ex.printStackTrace();        }
        return arr;
    }

    public void ajouterEvent(produit p) {
        try {

            ste = con.createStatement();
            String requeteInsert = "INSERT INTO produit (nomprod,qt,prix,description,image,idcat) VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(requeteInsert);
            pst.setString(1, p.getNomprod());
        //    pst.setString(2, p.getQt());
         //   pst.setString(3, p.getPrix());
            pst.setString(4, p.getDescription());
            pst.setString(5, p.getImage());
           // pst.setString(6, p.getIdCat());

 if (pst.executeUpdate() != 0) {
                System.out.println("prod deleted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Serviceproduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public String getImage(int idP) {
        String role = "";
        try {
            PreparedStatement pre = con.prepareStatement("select image from produit where id=?");
            pre.setInt(1, idP);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                role = rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return role;
    }

    public int numberevent () throws SQLException{
         int y=0;
          ste=con.createStatement() ;
           ResultSet rs=ste.executeQuery("SELECT COUNT(*) as total FROM evenement ");
           while(rs.next())
           {
                y = rs.getInt("total");
               
               
           }
           System.out.println("total number : "+y);
           return y;
         
     }
/*public produit findbyid(int idP) {
        produit u = new produit();
        try {

            PreparedStatement pre = con.prepareStatement("Select * from produit  WHERE idP=? ");
            pre.setInt(1, idP);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int nbPlaces =rs.getInt("nbPlaces");
                String nomEvent = rs.getString("nomEvent");
             float prix =rs.getFloat("prix");
              String image = rs.getString("image");
            
            
          u.setNomEvent(nomEvent);
              u.setPrix(prix);
              u.setImage(image);
              u.setNbPlaces(nbPlaces);
              //heli projet mte3i
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return u;
    }
/*public int getquantite(int id) {
        int q = 0;
//akeka mao ?oui
        String requete4 = "select nbPlaces from evenement where id=?;";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(requete4);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                q = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return q;
    }

    public void decrementqte(int id) {
        int q = getquantite(id);
        q--;
        String requete4 = "update evenement SET nbPlaces=? where id=?;";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(requete4);
            pst.setInt(1, q);

            pst.setInt(2, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
        }
    }

    public int findbyImage(String image) {
        int u = 0;
        try {

            PreparedStatement pre = con.prepareStatement("Select * from evenement  WHERE image=? ");
            pre.setString(1, image);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
             
                 u = rs.getInt("id");
             
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return u;
    }*/

    public produit[] ajouterEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public boolean supprimer(produit p) throws SQLException {

        String reqeute = "delete from produit  where (idP = ?) ;";
        try {
            PreparedStatement pst = con.prepareStatement(reqeute);
            pst.setInt(1, p.getIdP());
            // pst.setString(2, m.setDescription(reqeute));
            if (pst.executeUpdate() != 0) {
                System.out.println("supp©");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return false;
//To change body of generated methods, choose Tools | Templates.
    }
     
      public boolean modifierprod(String nomprod) {
 String requete = "UPDATE produit SET  nomprod= ?  where idP=?;";
        try {
            //imchi badel trah khali ken 3al nom  sayeb
            PreparedStatement pst = con.prepareStatement(requete);

            pst.setString(1, nomprod);
            //pst.setString(2, adresse);
           // pst.setString(3, type);
            //pst.setInt(2, idP);
            //zaama khater l id mch auto aamel mochkla ?
            // hatitou auto 

            if (pst.executeUpdate() != 0) {
                System.out.println("Evenement Updated");
            } else {
                System.out.println("non");
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return false;
    }

      
      
      public void ajouterpp(produit p)   {
       

        try {
            ste = con.createStatement();
            String requeteInsert = "INSERT INTO produit (nomprod,prix,qt,description,image,idcat) VALUES (?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(requeteInsert);
            pst.setString(1, p.getNomprod());
            pst.setDouble(2, p.getPrix());
            pst.setInt(3, p.getQt());
            pst.setString(4, p.getDescription());
            pst.setString(5, p.getImage());
            pst.setInt(6, p.getIdCat());

            


            
            pst.executeUpdate(); 
        } catch (SQLException ex) {
ex.printStackTrace();
        }
           

    }
    
public  int upadate (produit p)
{ int st=0 ; 
    try {
        String sql ="UPDATE produit SET idP=?,nompod=?,description=?,prix=?,qt=?,image=?,idcat=? WHERE idP=?";
 PreparedStatement stat;
 stat=con.prepareStatement(sql) ;
 stat.setInt(1, p.getIdP());
  stat.setString(2, p.getNomprod());
 
   stat.setString(3, p.getDescription());
    stat.setString(4, p.getImage());
      stat.setInt(5, p.getQt());
     stat.setDouble(6, p.getPrix());
      
    
       stat.setInt(7, p.getIdCat());
       st=stat.executeUpdate();
    } catch (Exception e) { e.printStackTrace();
    }
 
return st ; 
}
}
