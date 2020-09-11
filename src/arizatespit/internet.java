/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

/**
 *
 * @author Acer
 */
public class internet extends anaariza{
     private anaariza arizanet;
    private int hız;
    private String modem;
  //OVERLOAD
    public internet() {
       /* arizanet=new anaariza();
        arizanet.setFiyat(45);*/
    }
//OVERLOAD
    public internet(int hız, String modem) {
        this.hız = hız;
        this.modem = modem;
    }

    public internet(int hız, String modem, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.hız = hız;
        this.modem = modem;
    }

    public int getHız() {
        return hız;
    }

    public void setHız(int hız) {
        this.hız = hız;
    }

    public String getModem() {
        return modem;
    }

    public void setModem(String modem) {
        this.modem = modem;
    }

    //kompozisyon
    /*@Override
    public int getFiyat() {
        return arizanet.getFiyat(); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getModem()+ "^" + this.getHız()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }
    
    
}

/*class internett extends internetariza{
   
    public static void main(String[] args) {
        
       internetariza mymodem=new  modem();
       
       internetariza mywifi=new wifi();
       
       internetariza mykesinti=new kesinti();
       
       internetariza mynet=new internetariza();
       
       mymodem.net();
       
       mywifi.net();
       
       mykesinti.net();
       
       mynet.net();
        
    }
    
    
    
}*/