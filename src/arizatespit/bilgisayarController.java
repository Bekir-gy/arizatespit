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
public class bilgisayarController extends AnamenuController implements Initializable {

    @FXML private TableView<bilgisayar> tableview3;
     @FXML private TableColumn<bilgisayar,String> sistem3;
     @FXML private TableColumn<bilgisayar,Integer> versiyon3;
     @FXML private TableColumn<bilgisayar,String> tarih3;
     @FXML private TableColumn<bilgisayar,String> adres3;
     @FXML private TableColumn<bilgisayar,String> neden3;
     @FXML private TableColumn<bilgisayar,Integer> id3;
     @FXML private TableColumn<bilgisayar,Integer> fiyat3;
     
      @FXML private TextField pc_id;
      @FXML private TextField pc_fiyat;
       @FXML private TextField pc_sistem;
        @FXML private TextField pc_versiyon;
         @FXML private TextArea pc_adres;
          @FXML private TextField pc_neden;
      @FXML private TextField pc_tarih;
      
      @FXML private TextField arapc; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            Oku();
            // TODO
            sistem3.setCellValueFactory(new PropertyValueFactory<bilgisayar,String> ("sistem"));
            versiyon3.setCellValueFactory(new PropertyValueFactory<bilgisayar,Integer> ("versiyon"));
            tarih3.setCellValueFactory(new PropertyValueFactory<bilgisayar,String> ("teslimtarih"));
            adres3.setCellValueFactory(new PropertyValueFactory<bilgisayar,String> ("adres"));
            neden3.setCellValueFactory(new PropertyValueFactory<bilgisayar,String> ("arizanedeni"));
            fiyat3.setCellValueFactory(new PropertyValueFactory<bilgisayar,Integer> ("fiyat"));
            id3.setCellValueFactory(new PropertyValueFactory<bilgisayar,Integer> ("id"));
            
            tableview3.setItems(getpc);
        } catch (IOException ex) {
            Logger.getLogger(bilgisayarController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    
}
    public ObservableList<bilgisayar> getpc=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        Dosyaislem  txt= new Dosyaislem();

            public void Oku() throws IOException{
            liste.clear();
            getpc.clear();
            txt.TxtReader("bilgisayar.txt",liste);
            
            bilgisayar tmp;
             for (int i = 0; i < txt.Length("bilgisayar.txt"); i++) {
            tmp = new bilgisayar();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setSistem(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setVersiyon(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&"))));
            tmp.setArizanedeni(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setTeslimtarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            getpc.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
        try {
            getpc.add(getData());
            pc_id.clear();
            pc_fiyat.clear();
            pc_sistem.clear();
            pc_versiyon.clear();
            pc_neden.clear();
            pc_tarih.clear();
            pc_adres.clear();
            
            txt.addLine("bilgisayar.txt", getpc.get(getpc.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(bilgisayarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
        if (index <= -1) {
            return;
        }else{
            getpc.set(index, getData());
            pc_id.clear();
            pc_fiyat.clear();
            pc_sistem.clear();
            pc_versiyon.clear();
            pc_neden.clear();
            pc_tarih.clear();
            pc_adres.clear();
            for (int i = 0; i < getpc.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("bilgisayar.txt", getpc.get(i).toString(), false);

                    } else {

                        txt.addLine("bilgisayar.txt", getpc.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(bilgisayarController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
    }}

    @Override
    public void sil() {
        if (index <= -1) {
            return;
            
          }
        else{
            tableview3.getItems().remove(index);
            index = -1;
            pc_id.clear();
            pc_fiyat.clear();
            pc_sistem.clear();
            pc_versiyon.clear();
            pc_neden.clear();
            pc_tarih.clear();
            pc_adres.clear();
            for (int i = 0; i < getpc.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("bilgisayar.txt", getpc.get(i).toString(), false);

                    } else {

                        txt.addLine("bilgisayar.txt", getpc.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(bilgisayarController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
        arapc.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (arapc.textProperty().get().isEmpty()) {
                    tableview3.setItems(getpc);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<bilgisayar> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<bilgisayar, ?>> column = tableview3.getColumns();
                
                for (int row = 0; row < getpc.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(getpc.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(arapc.getText().toLowerCase()) && celValue.startsWith(arapc.getText().toLowerCase())) {
                            items.add(getpc.get(row));
                            break;
                        }
                    }

                }
                tableview3.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
         index = tableview3.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        pc_id.setText(id3.getCellData(index).toString());
        pc_fiyat.setText(fiyat3.getCellData(index).toString());
        pc_adres.setText(adres3.getCellData(index));
        pc_sistem.setText(sistem3.getCellData(index));
        pc_versiyon.setText(versiyon3.getCellData(index).toString());
        pc_neden.setText(neden3.getCellData(index));
        pc_tarih.setText(tarih3.getCellData(index));
    }
    
    
     public bilgisayar getData() {
        int id = Integer.parseInt(pc_id.getText());
        int fiyat = Integer.parseInt(pc_fiyat.getText());
         int versiyon = Integer.parseInt(pc_versiyon.getText());
        String adres = pc_adres.getText();
        
        String sistem = pc_sistem.getText();
        
        
        String neden = pc_neden.getText();
        String tarih = pc_tarih.getText();
        
       
       return new bilgisayar(sistem, versiyon, id, fiyat, adres, neden, tarih);

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