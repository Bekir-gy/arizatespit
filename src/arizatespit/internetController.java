/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class internetController extends AnamenuController implements Initializable {

    @FXML private TableView<internet> tableview6;
     @FXML private TableColumn<internet,String> modem6;
     @FXML private TableColumn<internet,Integer> hız6;
     @FXML private TableColumn<internet,String> tarih6;
     @FXML private TableColumn<internet,String> adres6;
     @FXML private TableColumn<internet,String> neden6;
     @FXML private TableColumn<internet,Integer> id6;
     @FXML private TableColumn<internet,Integer> fiyat6;
    
    @FXML private TextField i_id;
      @FXML private TextField i_fiyat;
       @FXML private TextField i_hız;
        @FXML private TextField i_modem;
         @FXML private TextArea i_adres;
          @FXML private TextField i_neden;
      @FXML private TextField i_tarih;
      
      @FXML private TextField arainternet;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
            // TODO
            modem6.setCellValueFactory(new PropertyValueFactory<internet,String> ("modem"));
            hız6.setCellValueFactory(new PropertyValueFactory<internet,Integer> ("hız"));
            tarih6.setCellValueFactory(new PropertyValueFactory<internet,String> ("teslimtarih"));
            adres6.setCellValueFactory(new PropertyValueFactory<internet,String> ("adres"));
            neden6.setCellValueFactory(new PropertyValueFactory<internet,String> ("arizanedeni"));
            fiyat6.setCellValueFactory(new PropertyValueFactory<internet,Integer> ("fiyat"));
            id6.setCellValueFactory(new PropertyValueFactory<internet,Integer> ("id"));
            
            tableview6.setItems(getinternet);
        } catch (IOException ex) {
            Logger.getLogger(internetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public ObservableList<internet> getinternet=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
        
         public void Oku() throws IOException{
            liste.clear();
            getinternet.clear();
            txt.TxtReader("internet.txt",liste);
            
            internet tmp;
             for (int i = 0; i < txt.Length("internet.txt"); i++) {
            tmp = new internet();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setModem(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setHız(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            getinternet.add(tmp);
        }
            
        }

    @Override
    public void ekle() {
       try {
            getinternet.add(getData());
            i_id.clear();
            i_fiyat.clear();
            i_hız.clear();
            i_modem.clear();
            i_neden.clear();
            i_tarih.clear();
            i_adres.clear();
            
            txt.addLine("internet.txt", getinternet.get(getinternet.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(internetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
         if (index <= -1) {
            return;
        }else{
            getinternet.set(index, getData());
            i_id.clear();
            i_fiyat.clear();
            i_modem.clear();
            i_hız.clear();
            i_neden.clear();
            i_tarih.clear();
            i_adres.clear();
            for (int i = 0; i < getinternet.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("internet.txt", getinternet.get(i).toString(), false);

                    } else {

                        txt.addLine("internet.txt", getinternet.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(internetController.class.getName()).log(Level.SEVERE, null, ex);
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
            tableview6.getItems().remove(index);
            index = -1;
            i_id.clear();
            i_fiyat.clear();
            i_hız.clear();
            i_modem.clear();
            i_neden.clear();
            i_tarih.clear();
            i_adres.clear();
            for (int i = 0; i < getinternet.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("internet.txt", getinternet.get(i).toString(), false);

                    } else {

                        txt.addLine("internet.txt", getinternet.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(internetController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
       arainternet.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (arainternet.textProperty().get().isEmpty()) {
                    tableview6.setItems(getinternet);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<internet> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<internet, ?>> column = tableview6.getColumns();
                
                for (int row = 0; row < getinternet.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(getinternet.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(arainternet.getText().toLowerCase()) && celValue.startsWith(arainternet.getText().toLowerCase())) {
                            items.add(getinternet.get(row));
                            break;
                        }
                    }

                }
                tableview6.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
        index = tableview6.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        i_id.setText(id6.getCellData(index).toString());
        i_fiyat.setText(fiyat6.getCellData(index).toString());
        i_adres.setText(adres6.getCellData(index));
        i_modem.setText(modem6.getCellData(index));
        i_hız.setText(hız6.getCellData(index).toString());
        i_neden.setText(neden6.getCellData(index));
        i_tarih.setText(tarih6.getCellData(index));
    }
    
    public internet getData() {
        int id = Integer.parseInt(i_id.getText());
        int fiyat = Integer.parseInt(i_fiyat.getText());
         int hız = Integer.parseInt(i_hız.getText());
        String adres = i_adres.getText();
        
        String modem = i_modem.getText();
        
        
        String neden = i_neden.getText();
        String tarih = i_tarih.getText();
        
       
        return new internet(hız, modem, id, fiyat, adres, neden, tarih);

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
