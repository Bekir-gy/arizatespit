/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class beyazesyaController extends AnamenuController implements Initializable {

    @FXML private TableView<beyazesya> tableview;
     @FXML private TableColumn<beyazesya,String> marka;
     @FXML private TableColumn<beyazesya,String> model;
     @FXML private TableColumn<beyazesya,String> tarih;
     @FXML private TableColumn<beyazesya,String> adres;
     @FXML private TableColumn<beyazesya,String> neden;
     @FXML private TableColumn<beyazesya,Integer> id;
     @FXML private TableColumn<beyazesya,Integer> fiyat;
     
     
     @FXML private TextField b_id;
      @FXML private TextField b_fiyat;
       @FXML private TextField b_marka;
        @FXML private TextField b_model;
         @FXML private TextArea b_adres;
          @FXML private TextField b_neden;
      @FXML private TextField b_tarih;
      
      @FXML private TextField arabeyaz;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
            // TODO
            marka.setCellValueFactory(new PropertyValueFactory<beyazesya,String> ("marka"));
            model.setCellValueFactory(new PropertyValueFactory<beyazesya,String> ("modeli"));
            tarih.setCellValueFactory(new PropertyValueFactory<beyazesya,String> ("teslimtarih"));
             adres.setCellValueFactory(new PropertyValueFactory<beyazesya,String> ("adres"));
              neden.setCellValueFactory(new PropertyValueFactory<beyazesya,String> ("arizanedeni"));
               fiyat.setCellValueFactory(new PropertyValueFactory<beyazesya,Integer> ("fiyat"));
             id.setCellValueFactory(new PropertyValueFactory<beyazesya,Integer> ("id"));
            
            tableview.setItems(getbeyaz);
        } catch (IOException ex) {
            Logger.getLogger(beyazesyaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public ObservableList<beyazesya> getbeyaz=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
        
        public void Oku() throws IOException{
            liste.clear();
            getbeyaz.clear();
            txt.TxtReader("beyazesya.txt",liste);
            
            beyazesya tmp;
             for (int i = 0; i < txt.Length("beyazesya.txt"); i++) {
            tmp = new beyazesya();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMarka(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setModeli(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            getbeyaz.add(tmp);
        }
            
        }

    @Override
    public void ekle() {
        try {
            getbeyaz.add(getData());
            b_id.clear();
            b_fiyat.clear();
            b_marka.clear();
            b_model.clear();
            b_neden.clear();
            b_tarih.clear();
            b_adres.clear();
            
            txt.addLine("beyazesya.txt", getbeyaz.get(getbeyaz.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(beyazesyaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
        if (index <= -1) {
            return;
        }else{
            getbeyaz.set(index, getData());
            b_id.clear();
            b_fiyat.clear();
            b_marka.clear();
            b_model.clear();
            b_neden.clear();
            b_tarih.clear();
            b_adres.clear();
            for (int i = 0; i < getbeyaz.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("beyazesya.txt", getbeyaz.get(i).toString(), false);

                    } else {

                        txt.addLine("beyazesya.txt", getbeyaz.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(beyazesyaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        
    }

    @Override
    public void sil() {
        if (index <= -1) {
            return;
            
          }
        else{
            tableview.getItems().remove(index);
            index = -1;
            b_id.clear();
            b_fiyat.clear();
            b_marka.clear();
            b_model.clear();
            b_neden.clear();
            b_tarih.clear();
            b_adres.clear();
            for (int i = 0; i < getbeyaz.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("beyazesya.txt", getbeyaz.get(i).toString(), false);

                    } else {

                        txt.addLine("beyazesya.txt", getbeyaz.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(beyazesyaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
         arabeyaz.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (arabeyaz.textProperty().get().isEmpty()) {
                    tableview.setItems(getbeyaz);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<beyazesya> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<beyazesya, ?>> column = tableview.getColumns();
                
                for (int row = 0; row < getbeyaz.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(getbeyaz.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(arabeyaz.getText().toLowerCase()) && celValue.startsWith(arabeyaz.getText().toLowerCase())) {
                            items.add(getbeyaz.get(row));
                            break;
                        }
                    }

                }
                tableview.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
        index = tableview.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        b_id.setText(id.getCellData(index).toString());
        b_fiyat.setText(fiyat.getCellData(index).toString());
        b_adres.setText(adres.getCellData(index));
        b_marka.setText(marka.getCellData(index));
        b_model.setText(model.getCellData(index));
        b_neden.setText(neden.getCellData(index));
        b_tarih.setText(tarih.getCellData(index));
    }
   
     public beyazesya getData() {
        int id = Integer.parseInt(b_id.getText());
        int fiyat = Integer.parseInt(b_fiyat.getText());
        String adres = b_adres.getText();
        
        String marka = b_marka.getText();
        
        String model = b_model.getText();
        String neden = b_neden.getText();
        String tarih = b_tarih.getText();
        
       
        return new beyazesya(marka, model, id, fiyat, adres, neden, tarih);

    }
     
    @Override
    public void geri(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("anamenu.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ANA MENU");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);
            
        } catch (IOException ex) {

        }

    }
    
}
