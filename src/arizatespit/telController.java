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
public class telController extends AnamenuController implements Initializable {

    @FXML private TableView<tel> tableview2;
     @FXML private TableColumn<tel,String> sistem2;
     @FXML private TableColumn<tel,Integer> versiyon2;
     @FXML private TableColumn<tel,String> tarih2;
     @FXML private TableColumn<tel,String> adres2;
     @FXML private TableColumn<tel,String> neden2;
     @FXML private TableColumn<tel,Integer> id2;
     @FXML private TableColumn<tel,Integer> fiyat2;
     
      @FXML private TextField t_id;
      @FXML private TextField t_fiyat;
       @FXML private TextField t_sistem;
        @FXML private TextField t_versiyon;
         @FXML private TextArea t_adres;
          @FXML private TextField t_neden;
      @FXML private TextField t_tarih;
      
      @FXML private TextField aratel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
            // TODO
            sistem2.setCellValueFactory(new PropertyValueFactory<tel,String> ("sistem"));
            versiyon2.setCellValueFactory(new PropertyValueFactory<tel,Integer> ("versiyon"));
            tarih2.setCellValueFactory(new PropertyValueFactory<tel,String> ("teslimtarih"));
             adres2.setCellValueFactory(new PropertyValueFactory<tel,String> ("adres"));
              neden2.setCellValueFactory(new PropertyValueFactory<tel,String> ("arizanedeni"));
               fiyat2.setCellValueFactory(new PropertyValueFactory<tel,Integer> ("fiyat"));
             id2.setCellValueFactory(new PropertyValueFactory<tel,Integer> ("id"));
            
            tableview2.setItems(gettel);
        } catch (IOException ex) {
            Logger.getLogger(telController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public ObservableList<tel> gettel=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
 public void Oku() throws IOException{
            liste.clear();
            gettel.clear();
            txt.TxtReader("tel.txt",liste);
            
            tel tmp;
             for (int i = 0; i < txt.Length("tel.txt"); i++) {
            tmp = new tel();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setSistem(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setVersiyon(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            gettel.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
         try {
            gettel.add(getData());
            t_id.clear();
            t_fiyat.clear();
            t_sistem.clear();
            t_versiyon.clear();
            t_neden.clear();
            t_tarih.clear();
            t_adres.clear();
            
            txt.addLine("tel.txt", gettel.get(gettel.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(telController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
              if (index <= -1) {
            return;
        }else{
            gettel.set(index, getData());
            t_id.clear();
            t_fiyat.clear();
            t_sistem.clear();
            t_versiyon.clear();
            t_neden.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < gettel.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tel.txt", gettel.get(i).toString(), false);

                    } else {

                        txt.addLine("tel.txt", gettel.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(telController.class.getName()).log(Level.SEVERE, null, ex);
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
            tableview2.getItems().remove(index);
            index = -1;
            t_id.clear();
            t_fiyat.clear();
            t_sistem.clear();
            t_versiyon.clear();
            t_neden.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < gettel.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tel.txt", gettel.get(i).toString(), false);

                    } else {

                        txt.addLine("tel.txt", gettel.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(telController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
        aratel.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (aratel.textProperty().get().isEmpty()) {
                    tableview2.setItems(gettel);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<tel> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<tel, ?>> column = tableview2.getColumns();
                
                for (int row = 0; row < gettel.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(gettel.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(aratel.getText().toLowerCase()) && celValue.startsWith(aratel.getText().toLowerCase())) {
                            items.add(gettel.get(row));
                            break;
                        }
                    }

                }
                tableview2.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
          index = tableview2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        t_id.setText(id2.getCellData(index).toString());
        t_fiyat.setText(fiyat2.getCellData(index).toString());
        t_adres.setText(adres2.getCellData(index));
        t_sistem.setText(sistem2.getCellData(index));
        t_versiyon.setText(versiyon2.getCellData(index).toString());
        t_neden.setText(neden2.getCellData(index));
        t_tarih.setText(tarih2.getCellData(index));
    }
    
     public tel getData() {
        int id = Integer.parseInt(t_id.getText());
        int fiyat = Integer.parseInt(t_fiyat.getText());
         int versiyon = Integer.parseInt(t_versiyon.getText());
        String adres = t_adres.getText();
        
        String sistem = t_sistem.getText();
        
        
        String neden = t_neden.getText();
        String tarih = t_tarih.getText();
        
       
        return new tel(sistem, versiyon, id, fiyat, adres, neden, tarih);

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
