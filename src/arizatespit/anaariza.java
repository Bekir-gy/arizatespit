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
 class anaariza {
    private int id;
    protected int fiyat;
    private String adres;
    private String arizanedeni;
    private String teslimtarih;
    protected int zam;

    public anaariza() {
    }
    
    //OVERLOAD POLYMORPHİZM
    protected int zamlar(int sure){
        if(sure>15)
        zam=fiyat*2;
        return zam;
    }
    //OVERLOAD POLYMORPHİZM
    protected void zamlar(double sure){
        if(sure<14.5)
            zam=(int) (fiyat*1.7);
        System.out.println(zam);
        
    }
    //overload polymorphizm
    protected String zamlar(String a, String b){
        String s=a+b;
        System.out.println("oluşturulan zam durumu");
        return s;
    }

    public anaariza(int id, int fiyat, String adres, String arizanedeni, String teslimtarih) {
        this.id = id;
        this.fiyat = fiyat;
        this.adres = adres;
        this.arizanedeni = arizanedeni;
        this.teslimtarih = teslimtarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        
        this.id = id;
    }

    public String getArizanedeni() {
        return arizanedeni;
    }

    public void setArizanedeni(String arizanedeni) {
        this.arizanedeni = arizanedeni;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
        
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
         //fiyat=100;
        this.fiyat = fiyat;
    }

    public String getTeslimtarih() {
        return teslimtarih;
    }

    public void setTeslimtarih(String teslimtarih) {
        this.teslimtarih = teslimtarih;
    }

    @Override
    public String toString() {
        return "anaariza{" + "id=" + id + ", fiyat=" + fiyat + ", adres=" + adres + ", arizanedeni=" + arizanedeni + ", teslimtarih=" + teslimtarih + '}';
    }
    
    
       
}
//OVERLOAD 
/*class mainnn extends anaariza{
    public static void main(String[] args){
        mainnn obj=new mainnn();
      
        int a = obj.zamlar(20);
        obj.zamlar(11.7);
        String c=obj.zamlar("öngörülen", "artış sağlandı");
        System.out.println(a+c);
    }
    
    
}*/