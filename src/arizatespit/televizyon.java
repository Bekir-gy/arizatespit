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
public class televizyon extends anaariza{
    anaariza ariza;
    String marka;
     String türü;
   
    private int inc;
    public televizyon() {
        //kompozisyon
        /*this.ariza=new anaariza();
        ariza.setFiyat(1500);*/
    }

    public televizyon(String marka, String türü, int inc) {
        this.marka = marka;
        this.türü = türü;
        this.inc = inc;
    }

   

    public televizyon(String marka, String türü, int inc, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.marka = marka;
        this.türü = türü;
        this.inc = inc;
    }

   

    

    

   

    

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTürü() {
        return türü;
    }

    public void setTürü(String türü) {
        this.türü = türü;
    }

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    
    

  /*  @Override
    public void setFiyat(int fiyat) {
        super.setFiyat(150); //To change body of generated methods, choose Tools | Templates.
    }

   //kompozisyon
    @Override
    public int getFiyat(){
        return ariza.getFiyat();
        
    }*/

  @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getMarka()+ "^" + this.getInc()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" + this.getTürü()+ "]]" ;
    }

    
    
    
    
    
    
}
