/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class Arizatespit extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(parent);
        primaryStage.setTitle("ANA SAYFA");
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch(IOException e){
            Logger.getLogger(Arizatespit.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    

   
    
}
