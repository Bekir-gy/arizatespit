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
public class elektrikController extends AnamenuController implements Initializable {

   @FXML private TableView<elektrik> tableview7;
     @FXML private TableColumn<elektrik,String> marka7;
     @FXML private TableColumn<elektrik,Integer> sigorta7;
     @FXML private TableColumn<elektrik,String> tarih7;
     @FXML private TableColumn<elektrik,String> adres7;
     @FXML private TableColumn<elektrik,String> neden7;
     @FXML private TableColumn<elektrik,Integer> id7;
     @FXML private TableColumn<elektrik,Integer> fiyat7;
     
     @FXML private TextField e_id;
      @FXML private TextField e_fiyat;
       @FXML private TextField e_sigorta;
        @FXML private TextField e_marka;
         @FXML private TextArea e_adres;
          @FXML private TextField e_neden;
      @FXML private TextField e_tarih;
     
      @FXML private TextField araelektrik;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try {
           Oku();
           // TODO
           marka7.setCellValueFactory(new PropertyValueFactory<elektrik,String> ("marka"));
           sigorta7.setCellValueFactory(new PropertyValueFactory<elektrik,Integer> ("sigorta"));
           tarih7.setCellValueFactory(new PropertyValueFactory<elektrik,String> ("teslimtarih"));
           adres7.setCellValueFactory(new PropertyValueFactory<elektrik,String> ("adres"));
           neden7.setCellValueFactory(new PropertyValueFactory<elektrik,String> ("arizanedeni"));
           fiyat7.setCellValueFactory(new PropertyValueFactory<elektrik,Integer> ("fiyat"));
           id7.setCellValueFactory(new PropertyValueFactory<elektrik,Integer> ("id"));
           
           tableview7.setItems(getelektrik);
       } catch (IOException ex) {
           Logger.getLogger(elektrikController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }    

     public ObservableList<elektrik> getelektrik=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
        
        public void Oku() throws IOException{
            liste.clear();
            getelektrik.clear();
            txt.TxtReader("elektrik.txt",liste);
            
            elektrik tmp;
             for (int i = 0; i < txt.Length("elektrik.txt"); i++) {
            tmp = new elektrik();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMarka(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setSigorta(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            getelektrik.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
         try {
            getelektrik.add(getData());
            e_id.clear();
            e_fiyat.clear();
            e_sigorta.clear();
            e_marka.clear();
            e_neden.clear();
            e_tarih.clear();
            e_adres.clear();
            
            txt.addLine("elektrik.txt", getelektrik.get(getelektrik.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(elektrikController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;
    @Override
    public void guncelle() {
         if (index <= -1) {
            return;
        }else{
            getelektrik.set(index, getData());
            e_id.clear();
            e_fiyat.clear();
            e_marka.clear();
            e_sigorta.clear();
            e_neden.clear();
            e_tarih.clear();
            e_adres.clear();
            for (int i = 0; i < getelektrik.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("elektrik.txt", getelektrik.get(i).toString(), false);

                    } else {

                        txt.addLine("elektrik.txt", getelektrik.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(elektrikController.class.getName()).log(Level.SEVERE, null, ex);
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
            tableview7.getItems().remove(index);
            index = -1;
            e_id.clear();
            e_fiyat.clear();
            e_sigorta.clear();
            e_marka.clear();
            e_neden.clear();
            e_tarih.clear();
            e_adres.clear();
            for (int i = 0; i < getelektrik.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("elektrik.txt", getelektrik.get(i).toString(), false);

                    } else {

                        txt.addLine("elektrik.txt", getelektrik.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(elektrikController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
       araelektrik.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (araelektrik.textProperty().get().isEmpty()) {
                    tableview7.setItems(getelektrik);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<elektrik> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<elektrik, ?>> column = tableview7.getColumns();
                
                for (int row = 0; row < getelektrik.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(getelektrik.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(araelektrik.getText().toLowerCase()) && celValue.startsWith(araelektrik.getText().toLowerCase())) {
                            items.add(getelektrik.get(row));
                            break;
                        }
                    }

                }
                tableview7.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
        index = tableview7.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        e_id.setText(id7.getCellData(index).toString());
        e_fiyat.setText(fiyat7.getCellData(index).toString());
        e_adres.setText(adres7.getCellData(index));
        e_marka.setText(marka7.getCellData(index));
        e_sigorta.setText(sigorta7.getCellData(index).toString());
        e_neden.setText(neden7.getCellData(index));
        e_tarih.setText(tarih7.getCellData(index));
    }
    
     public elektrik getData() {
        int id = Integer.parseInt(e_id.getText());
        int fiyat = Integer.parseInt(e_fiyat.getText());
         int sigorta = Integer.parseInt(e_sigorta.getText());
        String adres = e_adres.getText();
        
        String marka = e_marka.getText();
        
        
        String neden = e_neden.getText();
        String tarih = e_tarih.getText();
        
       
        return new elektrik(sigorta, marka, id, fiyat, adres, neden, tarih);

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
