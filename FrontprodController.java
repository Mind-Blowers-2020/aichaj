/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.huntkingdom.gui;
import edu.huntkingdom.services.Serviceproduit;
import edu.huntkingdom.entities.produit;
import edu.huntkingdom.utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.xml.ws.Holder;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FrontprodController implements Initializable {

    @FXML
    private AnchorPane Paneeventsfx;
    @FXML
    private ImageView imageeventspanefx;
    @FXML
    private Label subjecteventspanefx;
    @FXML
    private Label texteventspanefx;
    @FXML
    private Label DateeventsInteface;
    @FXML
    private AnchorPane Paneeventsfx1;
    @FXML
    private ImageView imageeventspanefx1;
    @FXML
    private Label subjecteventspanefx1;
    @FXML
    private Label texteventspanefx1;
    @FXML
    private Label DateeventsInteface1;
    @FXML
    private AnchorPane Paneeventsfx11;
    @FXML
    private ImageView imageeventspanefx11;
    @FXML
    private Label subjecteventspanefx11;
    @FXML
    private Label texteventspanefx11;
    @FXML
    private Label DateeventsInteface11;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtaddress;
    @FXML
    private ComboBox<?> combotype;
    @FXML
    private TextField txtprice;
    @FXML
    private TextField txtnumber;
    @FXML
    private TextField txtdescription;
    @FXML
    private TextField txtimage;
    @FXML
    private DatePicker combodateD;
    @FXML
    private DatePicker combodateF;
    private ObservableList<produit> data;
    private Connection con = null;
    
      Serviceproduit se = new Serviceproduit();
    int Current
            = 0;
    public static Holder<String> holdID = new Holder<String>();
    int i = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       data = FXCollections.observableArrayList();
        con = DataBase.getInstance().getConnection();
        data.addAll(se.readAll());
          try {
            getUserData(Current);
        } catch (SQLException ex) {//winou el fichier li baaththoulk anehou ely baaththoulk mail .jdk
            ex.printStackTrace();
        }
          
          

    }    
    public ArrayList<ImageView> ListImagese = new ArrayList<>();
    public ArrayList<Label> ListTextflowe = new ArrayList<>();
    public ArrayList<Label> Listlabeltitleevent = new ArrayList<>();
    public ArrayList<Label> Listdateevent = new ArrayList<>();
    public ArrayList<AnchorPane> Listpaneevent = new ArrayList<>();

    public ArrayList<AnchorPane> ListPaneeventsfx = new ArrayList<>();

    public void getUserData(int CurrentEvent) throws SQLException {

        Listpaneevent.add(Paneeventsfx);
        Listpaneevent.add(Paneeventsfx1);
        Listpaneevent.add(Paneeventsfx11);

        ListImagese.add(imageeventspanefx);
        ListImagese.add(imageeventspanefx1);
        ListImagese.add(imageeventspanefx11);

        ListTextflowe.add(texteventspanefx);
        ListTextflowe.add(texteventspanefx1);
        ListTextflowe.add(texteventspanefx11);

        Listlabeltitleevent.add(subjecteventspanefx);
        Listlabeltitleevent.add(subjecteventspanefx1);
        Listlabeltitleevent.add(subjecteventspanefx11);

        Listdateevent.add(DateeventsInteface);
        Listdateevent.add(DateeventsInteface1);
        Listdateevent.add(DateeventsInteface11);

        int Nombre = se.numberevent();
        int i = CurrentEvent;

        for (i = CurrentEvent; i < CurrentEvent + 3; i++) {
            System.out.println(data.get(i).getImage());
           Image image = new Image("http://localhost/back/web/images" + data.get(i).getImage());
            ListImagese.get(i).setImage(image);
            Listlabeltitleevent.get(i).setText(data.get(i).getNomprod());
            ListTextflowe.get(i).setText(data.get(i).getDescription());
            Listpaneevent.get(i).setVisible(true);

        }
        /*
        imageeventspanefx.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            System.out.println("id:"+data.get(CurrentEvent).getIdP());
            String numberAsString = Integer.toString(data.get(CurrentEvent).getIdP());
            holdID.value = numberAsString;
                String images = imageeventspanefx.getImage().impl_getUrl();
                int idP = se.findbyImage(images.substring(27));
                holdID.value = Integer.toString(idP);
                System.out.println("idP:" + idP);

                System.out.println("imagename:" + images.substring(27));
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("eventdetails.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

     /*   imageeventspanefx1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            System.out.println("idP:"+data.get(CurrentEvent+1).getIdP());
            String numberAsString = Integer.toString(data.get(CurrentEvent+1).getIdP());
            holdID.value = numberAsString;
                String images = imageeventspanefx1.getImage().impl_getUrl();
                //int id = se.findbyImage(images.substring(27));
                holdID.value = Integer.toString(idP);
                System.out.println("idP:" + idP);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("eventdetails.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
        /*imageeventspanefx11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            System.out.println("idP:"+data.get(CurrentEvent+2).getIdP());
            String numberAsString = Integer.toString(data.get(CurrentEvent+2).getIdP());
            holdID.value = numberAsString;
                String images = imageeventspanefx11.getImage().impl_getUrl();
                int id = se.findbyImage(images.substring(27));
                holdID.value = Integer.toString(id);
                System.out.println("id:" + id);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("eventdetails.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        });
 */
    }
   
    @FXML
    private void viewmore(ActionEvent event) {
    }

    @FXML
    private void upload(ActionEvent event) {
    }

    @FXML
    private void addevent(ActionEvent event) {
    }
    
}

