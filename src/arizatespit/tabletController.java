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
public class tabletController extends AnamenuController implements Initializable {

         @FXML private TableView<tablet> tableview4;
     @FXML private TableColumn<tablet,String> marka4;
     @FXML private TableColumn<tablet,Integer> inc4;
     @FXML private TableColumn<tablet,String> tarih4;
     @FXML private TableColumn<tablet,String> adres4;
     @FXML private TableColumn<tablet,String> neden4;
     @FXML private TableColumn<tablet,Integer> id4;
     @FXML private TableColumn<tablet,Integer> fiyat4;
     
      @FXML private TextField ta_id;
      @FXML private TextField ta_fiyat;
       @FXML private TextField ta_inc;
        @FXML private TextField ta_marka;
         @FXML private TextArea ta_adres;
          @FXML private TextField ta_neden;
      @FXML private TextField ta_tarih;
      
      @FXML private TextField aratablet;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             try {
                 Oku();
                 // TODO
                 marka4.setCellValueFactory(new PropertyValueFactory<tablet,String> ("marka"));
                 inc4.setCellValueFactory(new PropertyValueFactory<tablet,Integer> ("inc"));
                 tarih4.setCellValueFactory(new PropertyValueFactory<tablet,String> ("teslimtarih"));
                 adres4.setCellValueFactory(new PropertyValueFactory<tablet,String> ("adres"));
                 neden4.setCellValueFactory(new PropertyValueFactory<tablet,String> ("arizanedeni"));
                 fiyat4.setCellValueFactory(new PropertyValueFactory<tablet,Integer> ("fiyat"));
                 id4.setCellValueFactory(new PropertyValueFactory<tablet,Integer> ("id"));
                 
                 tableview4.setItems(gettablet);
             } catch (IOException ex) {
                 Logger.getLogger(tabletController.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
    }   
     public ObservableList<tablet> gettablet=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();
        
        public void Oku() throws IOException{
            liste.clear();
            gettablet.clear();
            txt.TxtReader("tablet.txt",liste);
            
            tablet tmp;
             for (int i = 0; i < txt.Length("tablet.txt"); i++) {
            tmp = new tablet();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setMarka(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setInc(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            gettablet.add(tmp);
        }
            
        }

    @Override
    public void ekle() {
         try {
            gettablet.add(getData());
            ta_id.clear();
            ta_fiyat.clear();
            ta_inc.clear();
            ta_marka.clear();
            ta_neden.clear();
            ta_tarih.clear();
            ta_adres.clear();
            
            txt.addLine("tablet.txt", gettablet.get(gettablet.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(tabletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
int index;
    @Override
    public void guncelle() {
        if (index <= -1) {
            return;
        }else{
            gettablet.set(index, getData());
            ta_id.clear();
            ta_fiyat.clear();
            ta_marka.clear();
            ta_inc.clear();
            ta_neden.clear();
            ta_tarih.clear();
            ta_adres.clear();
            for (int i = 0; i < gettablet.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tablet.txt", gettablet.get(i).toString(), false);

                    } else {

                        txt.addLine("tablet.txt", gettablet.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(tabletController.class.getName()).log(Level.SEVERE, null, ex);
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
            tableview4.getItems().remove(index);
            index = -1;
            ta_id.clear();
            ta_fiyat.clear();
            ta_inc.clear();
            ta_marka.clear();
            ta_neden.clear();
            ta_tarih.clear();
            ta_adres.clear();
            for (int i = 0; i < gettablet.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tablet.txt", gettablet.get(i).toString(), false);

                    } else {

                        txt.addLine("tablet.txt", gettablet.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(tabletController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
        aratablet.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (aratablet.textProperty().get().isEmpty()) {
                    tableview4.setItems(gettablet);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<tablet> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<tablet, ?>> column = tableview4.getColumns();
                
                for (int row = 0; row < gettablet.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(gettablet.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(aratablet.getText().toLowerCase()) && celValue.startsWith(aratablet.getText().toLowerCase())) {
                            items.add(gettablet.get(row));
                            break;
                        }
                    }

                }
                tableview4.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
       index = tableview4.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        ta_id.setText(id4.getCellData(index).toString());
        ta_fiyat.setText(fiyat4.getCellData(index).toString());
        ta_adres.setText(adres4.getCellData(index));
        ta_marka.setText(marka4.getCellData(index));
        ta_inc.setText(inc4.getCellData(index).toString());
        ta_neden.setText(neden4.getCellData(index));
        ta_tarih.setText(tarih4.getCellData(index));
    }
    
    public tablet getData() {
        int id = Integer.parseInt(ta_id.getText());
        int fiyat = Integer.parseInt(ta_fiyat.getText());
         int inc = Integer.parseInt(ta_inc.getText());
        String adres = ta_adres.getText();
        
        String marka = ta_marka.getText();
        
        
        String neden = ta_neden.getText();
        String tarih = ta_tarih.getText();
        
       
        return new tablet(inc, marka, id, fiyat, adres, neden, tarih);

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
