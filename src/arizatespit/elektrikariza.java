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
 class elektrikariza {
    
    public void elektrika(){
        System.out.println("elektrik arızası giderildi, teşekkürler");
        
    }
    
}
class asirikuvvet extends elektrikariza{
    @Override
    public void elektrika(){
        System.out.println("aşırı kuvvet sonucu kısa devre oluştu");
    }
}
class kisadevre extends elektrikariza{
    @Override
    public void elektrika(){
        System.out.println("kısa devre giderildi topraklama bakılacak");
    }
}

class topraklama extends elektrikariza{
    @Override
    public void elektrika(){
        System.out.println("topraklama yapıldı");
    }
}