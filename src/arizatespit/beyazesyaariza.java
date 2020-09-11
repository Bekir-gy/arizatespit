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
class beyazesyaariza {
    public void beyaze(){
        System.out.println("tüm arızalar giderildi,teşekkürler");
    }
    
}
class sogutma extends beyazesyaariza{
    @Override
    public void beyaze(){
        System.out.println("deepfrize sistemi kontrol altında");
    }
}
class kompresor extends beyazesyaariza{
    @Override
    public void beyaze(){
        System.out.println("sogutucu contası onarıldı");
    }
}

class nem extends beyazesyaariza{
    @Override
    public void beyaze(){
        System.out.println("sogutma gazı sıkıldı");
    }
}

