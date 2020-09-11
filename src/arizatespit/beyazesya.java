/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arizatespit;
import arizatespit.*;
/**
 *
 * @author Acer
 */
public class beyazesya extends anaariza{
    private String marka;
    private String modeli;
    private anaariza arizabeyaz;
    public beyazesya() {
        arizabeyaz=new anaariza();
       /* arizabeyaz.setFiyat(650);*/
    }

    public beyazesya(String marka, String modeli, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.marka = marka;
        this.modeli = modeli;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    //kompozisyon
   /* @Override
    public int getFiyat() {
        return arizabeyaz.getFiyat(); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getMarka()+ "^" + this.getModeli()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }
    
    
   
}
/*class beyazesyaa extends beyazesyaariza{
    public static void main(String[] args) {
        
        beyazesyaariza mydeep= new sogutma();
        
        beyazesyaariza mykompresor=new kompresor();
        
        beyazesyaariza mynem=new nem();
        
        beyazesyaariza mybeyaz=new beyazesyaariza();
        
        mydeep.beyaze();
        
        mykompresor.beyaze();
        
        mynem.beyaze();
        
        mybeyaz.beyaze();
    }
    
}
*/