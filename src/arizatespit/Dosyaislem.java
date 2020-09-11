/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arizatespit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Dosyaislem {
    
     static File f=new File("ariza.txt");
     
   static void kayitekle(String s) {
       try{ 
           if(!f.exists())
            f.createNewFile();
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(s);
        bw.newLine();
        bw.close();}
       catch(IOException e){
           System.out.println(e.getMessage());
           
       }
       
    }
    
    static void kayitara(char c){
        try {
            FileReader fr= new FileReader(f);
             BufferedReader br=new BufferedReader(fr);
             String satir;
             while((satir=br.readLine())!=null){
                 if(satir.charAt(0)==c)
                     System.out.println(satir);
             }
             
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
   static void eklemenu(){
        Scanner scan=new Scanner(System.in);
        String s;
        while(true){
            System.out.println("EKLE MENUSU");
            System.out.println("kayıt giriniz ... çıkmak için 0 a basın");
            s=scan.nextLine();
            if(!s.equals("0")){
                kayitekle(s);
            }else break;
        }
        main(null);
    }
    
    static void aramenu(){
        Scanner scan=new Scanner(System.in);
        String s;
        while(true){
            System.out.println("ARA MENUSU");
            System.out.println("ARANILAN HARF ... çıkmak için 0 a basın");
            s=scan.nextLine();
            if(!s.equals("0")){
                kayitara(s.charAt(0));
            }else break;
        }
        main(null);
    
    
}
    static void oku(){
       
         try {
             FileReader fr= new FileReader(f);
             String str;
             fr.close();
             BufferedReader br=new BufferedReader(new FileReader(f));
             
             while((str=br.readLine())!= null){
                 System.out.println(br.readLine());
                 
             }
             br.close();
             main(null);
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
    }
    
    public static void main(String[] args)  {
       
        Scanner scan =new Scanner(System.in);
        String secimm="0";
        System.out.println("ANA MENÜ");
        System.out.println("KAYIT EKLEMEK İÇİN 1");
         System.out.println("KAYIT ARAMAK İÇİN 2");
         System.out.println("KAYIT OKUMAK İÇİN 3");
        
        secimm=scan.next();
        if(secimm.equals("1")){
            eklemenu();
           
        }else if(secimm.equals("2")){
            aramenu();
        }
        else if(secimm.equals("3")){
            oku();
        }
                
           
        
        
        
        
        
        
        
        
        
        /*File f=new File("ariza.txt");
        String str="ARIZA TAKİP SİSTEMİ DOSYA BÖLÜMÜ";
        
        if(!f.exists())  {
             System.out.println("DOSYA BULUNMUYOR");
            f.createNewFile();
           
        }
            
     
          FileWriter fw=new FileWriter(f,true);
         BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.newLine();
            bw.close();
        
        
            FileReader fr= new FileReader(f);
            fr.close();
            BufferedReader br=new BufferedReader(new FileReader(f));
            while((str=br.readLine())!= null){
              System.out.println(br.readLine());
                
            }
            br.close();
            
            
     
            
    }
        */
    
}
     public void TxtReader(String fileName, List<String> tmp) throws IOException {
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while(br.ready() == true) {
            tmp.add(br.readLine());
        }
        fr.close();
        br.close();
    }
     
      public int Length(String FileName) throws IOException {
        File f = new File(FileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int length = 0;
        while(br.ready() == true){
            br.readLine();
            length++;
        }
        return length;

    }
      public void addLine(String fileName, String tmp, boolean control) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName), control);
        fw.write(tmp+"\n");
        fw.close();
    }
    
    public void addLine(String fileName, String tmp) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName), true);
        fw.write(tmp+"\n");
        fw.close();
    }

    public void addFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();

    }
}
