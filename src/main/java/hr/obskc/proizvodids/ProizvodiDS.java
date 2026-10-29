/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package hr.obskc.proizvodids;

import java.io.PrintStream;

public class ProizvodiDS {

    public static void main(String[] args) {
        Proizvod first = new Proizvod("  Jaja     ", 3.20, 100);
        Proizvod second = new Proizvod("Kruh polubijeli", 1.80, 20);
        
        System.out.println(first.opis());
        System.out.println(second.opis());
        
        Proizvod third=new Proizvod("Mlijeko", 2.50, 46);
        System.out.println(third.opis());
        
        second.setCijena(3.00);
        System.out.println(first.getProizvod() + ": ima još "+first.getKolicina()+ "komada");
                
        try {
            Proizvod proizvod = new Proizvod ("    ", 6.60);
        } catch (IllegalArgumentException e) {
            System.out.println("Odbijeno: "+ e.getMessage());
        }
          
        
        System.out.printf("Ukupna vrijednost (%s): %.2f EUR%n", second.getProizvod(), second.ukupnaVrijednost());
        System.out.printf("Ukupna vrijednost uz 20 %% popusta (%s): %.2f EUR%n", second.getProizvod(), second.ukupnaVrijednost(20));
        
        System.out.println("Broj proizvoda: "+Proizvod.getProizvodBroj()); //statičke stvari pozivamo preko klase
        System.out.println("Zadana količina: "+ Proizvod.DEFAULT_KOLICINA);
        System.out.println("Je li P042 ispravna šifra? "+Proizvod.isValidKod("P042"));
        System.out.println("Je li X42 ispravna šifra? "+Proizvod.isValidKod("X42"));
        
        Proizvod[] program={first, second, third};
        int totalnaKolicina = 0;
        for (Proizvod c: program) {
            totalnaKolicina +=c.getKolicina();
        }
        System.out.println("Ukupna kolicina:" + totalnaKolicina);
       
                
        System.out.println("Preko varijable first: "+first.getKolicina()+ " komada");
        
     
        
      
       
       String typed="Jaja";
    System.out.println("== :"+ ("jaja".equals(typed)));
    System.out.println("equals: " + typed.equals("jaja"));
    System.out.println("isProizvod: "+ second.isProizvod(typed));
    
    String ime="jaja";
    String novoIme=ime.toUpperCase();
    System.out.println("Provjera imena: "+novoIme);
    
    StringBuilder poster=new StringBuilder("Program: ");
    for (Proizvod c:program) {
        poster.append(c.getProizvod()).append("; ");
    }
    
        System.out.println(poster);
    }
    
   
    
    static void replace(Proizvod c) {
        c=new Proizvod("Neki drugi", 1.00);
    }
   
}
