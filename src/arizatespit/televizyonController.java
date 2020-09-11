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
public class televizyonController extends  AnamenuController implements Initializable {
@FXML private TableView<televizyon> tableview5;
     @FXML private TableColumn<televizyon,String> marka5;
     @FXML private TableColumn<televizyon,Integer> inc5;
     @FXML private TableColumn<televizyon,String> tarih5;
     @FXML private TableColumn<televizyon,String> adres5;
     @FXML private TableColumn<televizyon,String> neden5;
     @FXML private TableColumn<televizyon,Integer> id5;
     @FXML private TableColumn<televizyon,Integer> fiyat5;
     @FXML private TableColumn<televizyon,String> türü5;
     
     
      @FXML private TextField te_id;
      @FXML private TextField te_fiyat;
       @FXML private TextField te_marka;
        @FXML private TextField te_türü;
         @FXML private TextArea te_adres;
          @FXML private TextField te_neden;
      @FXML private TextField te_tarih;
      @FXML private TextField te_inc;
      
      @FXML private TextField aratelevizyon;
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    try {
        Oku();
        // TODO
        marka5.setCellValueFactory(new PropertyValueFactory<televizyon,String> ("marka"));
        inc5.setCellValueFactory(new PropertyValueFactory<televizyon,Integer> ("inc"));
        tarih5.setCellValueFactory(new PropertyValueFactory<televizyon,String> ("teslimtarih"));
        adres5.setCellValueFactory(new PropertyValueFactory<televizyon,String> ("adres"));
        neden5.setCellValueFactory(new PropertyValueFactory<televizyon,String> ("arizanedeni"));
        fiyat5.setCellValueFactory(new PropertyValueFactory<televizyon,Integer> ("fiyat"));
        id5.setCellValueFactory(new PropertyValueFactory<televizyon,Integer> ("id"));
        türü5.setCellValueFactory(new PropertyValueFactory<televizyon,String> ("türü"));
        
        tableview5.setItems(gettelevizyon);
    } catch (IOException ex) {
        Logger.getLogger(televizyonController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }    

    public ObservableList<televizyon> gettelevizyon=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
        
         public void Oku() throws IOException{
            liste.clear();
            gettelevizyon.clear();
            txt.TxtReader("televizyon.txt",liste);
            
            televizyon tmp;
             for (int i = 0; i < txt.Length("televizyon.txt"); i++) {
            tmp = new televizyon();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMarka(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setInc(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            tmp.setTürü(liste.get(i).substring(liste.get(i).indexOf("@@") + 2, liste.get(i).indexOf("]]")));

            gettelevizyon.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
       try {
            gettelevizyon.add(getData());
            te_id.clear();
            te_fiyat.clear();
            te_inc.clear();
            te_marka.clear();
            te_neden.clear();
            te_tarih.clear();
            te_adres.clear();
            te_türü.clear();
            
            txt.addLine("televizyon.txt", gettelevizyon.get(gettelevizyon.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(televizyonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
int index;
    @Override
    public void guncelle() {
       if (index <= -1) {
            return;
        }else{
            gettelevizyon.set(index, getData());
            te_id.clear();
            te_fiyat.clear();
            te_marka.clear();
            te_inc.clear();
            te_neden.clear();
            te_tarih.clear();
            te_adres.clear();
            te_türü.clear();
            for (int i = 0; i < gettelevizyon.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("televizyon.txt", gettelevizyon.get(i).toString(), false);

                    } else {

                        txt.addLine("televizyon.txt", gettelevizyon.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(televizyonController.class.getName()).log(Level.SEVERE, null, ex);
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
            tableview5.getItems().remove(index);
            index = -1;
            te_id.clear();
            te_fiyat.clear();
            te_inc.clear();
            te_marka.clear();
            te_neden.clear();
            te_tarih.clear();
            te_adres.clear();
            te_türü.clear();
            for (int i = 0; i < gettelevizyon.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("televizyon.txt", gettelevizyon.get(i).toString(), false);

                    } else {

                        txt.addLine("televizyon.txt", gettelevizyon.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(televizyonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
       aratelevizyon.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (aratelevizyon.textProperty().get().isEmpty()) {
                    tableview5.setItems(gettelevizyon);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<televizyon> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<televizyon, ?>> column = tableview5.getColumns();
                
                for (int row = 0; row < gettelevizyon.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(gettelevizyon.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(aratelevizyon.getText().toLowerCase()) && celValue.startsWith(aratelevizyon.getText().toLowerCase())) {
                            items.add(gettelevizyon.get(row));
                            break;
                        }
                    }

                }
                tableview5.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
       index = tableview5.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        te_id.setText(id5.getCellData(index).toString());
        te_fiyat.setText(fiyat5.getCellData(index).toString());
        te_adres.setText(adres5.getCellData(index));
        te_marka.setText(marka5.getCellData(index));
        te_inc.setText(inc5.getCellData(index).toString());
        te_neden.setText(neden5.getCellData(index));
        te_tarih.setText(tarih5.getCellData(index));
        te_türü.setText(türü5.getCellData(index));
        
    }
    
     public televizyon getData() {
        int id = Integer.parseInt(te_id.getText());
        int fiyat = Integer.parseInt(te_fiyat.getText());
         int inc = Integer.parseInt(te_inc.getText());
        String adres = te_adres.getText();
        
        String marka = te_marka.getText();
        
        
        String neden = te_neden.getText();
        String tarih = te_tarih.getText();
         String türü = te_türü.getText();
        
       
        return new televizyon(marka, türü, inc, id, fiyat, adres, neden, tarih);

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
