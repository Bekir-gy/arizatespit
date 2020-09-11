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
public class tel extends anaariza {

    private anaariza arizatel;
    String sistem;
    int versiyon;

    public tel() {
        this.arizatel = new anaariza();
        /*arizatel.setFiyat(200);*/
    }

    public tel(String sistem, int versiyon) {
        this.sistem = sistem;
        this.versiyon = versiyon;
    }

    public tel(String sistem, int versiyon, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.sistem = sistem;
        this.versiyon = versiyon;
    }

    public String getSistem() {
        return sistem;
    }

    public void setSistem(String sistem) {
        this.sistem = sistem;
    }

    public int getVersiyon() {
        return versiyon;
    }

    public void setVersiyon(int versiyon) {
        this.versiyon = versiyon;
    }

    //kompozisyon
   /* @Override
    public int getFiyat() {
        return arizatel.getFiyat();

    }*/

    @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getSistem()+ "^" + this.getVersiyon()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }

}
