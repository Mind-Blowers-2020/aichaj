/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class BackController implements Initializable {

    @FXML
    private BorderPane BorderPane;

    /**
     * Initializes the controller class.
     */
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

    @FXML
    private void decoOnAction(ActionEvent event) {
    }

    @FXML
    private void profileAction(ActionEvent event) {
    }

    @FXML
    private void eventAction(ActionEvent event) {
    }

    @FXML
    private void produitAction(ActionEvent event) {
          loadUi("produit");
    }

    @FXML
    private void categorieAction(ActionEvent event) {
        loadUi("categories");
    }

      
    
}
