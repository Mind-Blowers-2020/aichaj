/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.gui;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import edu.huntkingdom.entities.categorie;
import edu.huntkingdom.services.ServiceCategorie;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AjoutController implements Initializable {

    /**
     * Initializes the controller class.
     */    private BorderPane BorderPane;
    @FXML
    private JFXTextField txtnomcat;
    ServiceCategorie se = new ServiceCategorie();
    @FXML
    private JFXTextField txtnidcat;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     private void loadUi(String ui) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
ex.printStackTrace();        }
        BorderPane.setCenter(root); 
    }
    private void Ajout(ActionEvent event) {
        //houni tikhdem hedha l bouton tajouti bih :)
       
       
    }
        public int getTxtnumber() {
        return Integer.parseInt(txtnidcat.getText());
    }

    @FXML
    private void ajouterOnAction(ActionEvent event) throws SQLException {
        String nom = txtnomcat.getText();
        
        System.out.println(nom);
       categorie c = new categorie(getTxtnumber(),nom);
        se.ajouterEvent(c);  
    }

    
}
 
   
