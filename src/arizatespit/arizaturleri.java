/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class arizaturleri {

    
   public String ekrankirik(String adlar){
       Scanner girdi=new Scanner(System.in);
       System.out.println("EKRAN NASIL KIRILDI?");
       String ad=girdi.nextLine();
       return ad;
   }
    
    
    
}
