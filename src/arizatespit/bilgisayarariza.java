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
 class bilgisayarariza {
     
     public void pc(){
         System.out.println("biligisayarınız üzerinde gerekli onarım yapılmıstır.");
     }
    
}
class ram extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("ram slotları arızasi tespit ediildi");
    }
}
class cpu extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("cpu termal macunu yenilendi");
    }
}
class bios extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("bios pili değiştirildi");
    }
}
class vga extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("ekran karti chipseti ısıtıldı");
    }
}
class hdd extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("harddiskte bad sektörler tespit edildi");
    }
}
class sistem extends bilgisayarariza{
    @Override
    public void pc(){
        System.out.println("sistem bir üst versiyona yükseltildi");
    }
}
// polymorphism / override