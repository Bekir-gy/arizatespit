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
public class elektrik extends anaariza {

    private int sigorta;
    private String marka;
    
    private anaariza arizaelektrik;

    public elektrik() {
        /*arizaelektrik = new anaariza();
        arizaelektrik.setFiyat(130);*/
    }

    public elektrik(int sigorta, String marka) {
        this.sigorta = sigorta;
        this.marka = marka;
    }
    
    

    public elektrik(int sigorta, String marka, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.sigorta = sigorta;
        this.marka = marka;
    }

    

    public int getSigorta() {
        return sigorta;
    }

    public void setSigorta(int sigorta) {
        this.sigorta = sigorta;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

   

    

    
//kompozisyon

   /* @Override
    public int getFiyat() {
        return arizaelektrik.getFiyat(); //To change body of generated methods, choose Tools | Templates.
    }*/

     @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getMarka()+ "^" + this.getSigorta()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }
    

        
}
/*class elektrikk extends elektrikariza{
    public static void main(String[] args) {
        
        elektrikariza myasirii=new asirikuvvet();
        elektrikariza mykisa=new kisadevre();
        elektrikariza mytoprak=new topraklama();
        
        elektrikariza eee= new elektrikariza();
        myasirii.elektrika();
        mykisa.elektrika();
        mytoprak.elektrika();
        eee.elektrika();
    }
    
}*/
