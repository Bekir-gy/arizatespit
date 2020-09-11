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
public class bilgisayar extends anaariza{
    private String sistem;
    private int versiyon;
    private anaariza arizapc;

    public bilgisayar() {
       /* arizapc =new anaariza();
        arizapc.setFiyat(450);*/
    }

    public bilgisayar(String sistem, int versiyon, int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
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
  /*  @Override
    public int getFiyat(){
        return arizapc.getFiyat();
    }*/

     @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getSistem()+ "^" + this.getVersiyon()+ "&" + this.getArizanedeni()+ "*"
                + this.getTeslimtarih()+ "@@" ;
    }

   /* @Override
    public String toString() {
        return "bilgisayar{" + "sistem=" + sistem + ", versiyon=" + versiyon + ", arizapc=" + arizapc + '}';
    }*/
    
    
    
}
// polymorphism / override
/*class bilgisayarr extends bilgisayarariza{
    public static void main(String[] args) {
        
        
        
        bilgisayarariza myram=new ram();
        
        bilgisayarariza mycpu=new cpu();
        
        bilgisayarariza mybios=new bios();
        
        bilgisayarariza myvga=new vga();
        
        bilgisayarariza myhdd=new hdd();
        
        bilgisayarariza mysistem=new sistem();
        
        bilgisayarariza mypc=new bilgisayarariza();
        
        myram.pc();
        
        mycpu.pc();
        
        mybios.pc();
        
        myvga.pc();
        
        myhdd.pc();
        
        mysistem.pc();
        
        mypc.pc();
    }
    
}*/