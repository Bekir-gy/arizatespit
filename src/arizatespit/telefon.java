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
public class telefon extends anaariza{
    private int versiyon;

    public telefon() {
    }

    public telefon(int versiyon, int id, int fiyat, String adres, String teslimtarih , String arizanedeni) {
        super(id, fiyat, adres, arizanedeni, teslimtarih);
        this.versiyon = versiyon;
    }

    public int getVersiyon() {
        return versiyon;
    }

    public void setVersiyon(int versiyon) {
        this.versiyon = versiyon;
    }
}
