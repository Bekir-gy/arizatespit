/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    TextField username;
    @FXML
    PasswordField password;

    public void login(Event e) {
        try {
            if (username.getText().trim().matches("USER") && password.getText().equalsIgnoreCase("1234")) {

                Parent parent = FXMLLoader.load(getClass().getResource("anamenu.fxml"));

                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("ANA MENU");
                Rectangle2D rd = Screen.getPrimary().getVisualBounds();
                stage.setX((rd.getWidth() - stage.getWidth()) / 2);
                stage.setY((rd.getHeight() - stage.getHeight()) / 2);

            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Edin");
            }
        } catch (IOException ex) {
            
        }
    }

    public void exit() {
        Platform.exit();
    }
    
    public void telAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("tel.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("TELEFON ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    public void beyazesyaAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("beyazesya.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("BEYAZ EŞYA ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

            

         
           
          
        } catch (IOException ex) {

        }
    }

    public void bilgisayarAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("bilgisayar.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("BİLGİSAYAR ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    public void tabletAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("tablet.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("TABLET ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    public void televizyonAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("televizyon.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("TV ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    public void internetAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("internet.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("İNTERNET ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    public void elektrikAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("elektrik.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ELEKTRİK ARIZA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
