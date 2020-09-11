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
 class internetariza {
    
     public void net(){
         System.out.println("intenet alt yapınıdaki problem giderildi, teşekkürler");
     } 
}

class modem extends internetariza{
    @Override
    public void net(){
        System.out.println("modem fabrika ayarlarına dönderidi.");
    }
}
class wifi extends internetariza{
    @Override
    public void net(){
        System.out.println("wifi noktası bağlantı testi yapıldı");
    }
}

class kesinti extends internetariza{
    @Override
    public void net(){
        System.out.println("hat kesintisi için ekiplerimiz gönderildi ve hat onarıldı");
    }
}