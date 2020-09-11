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
public class tablet  extends anaariza{
    private int inc;
    private String marka;
    private anaariza arizatablet;

    public tablet(int inc, String marka, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.inc = inc;
        this.marka = marka;
    }
    public tablet() {
        /*arizatablet=new anaariza();
        arizatablet.setFiyat(300);*/
    }

    public tablet(int inc, String marka) {
        this.inc = inc;
        this.marka = marka;
    }

    
   

   

    
    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
    
    //kompozisyon
   /* @Override
    public int getFiyat(){
        return arizatablet.getFiyat();
    }*/

   @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getMarka()+ "^" + this.getInc()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }
    
}
