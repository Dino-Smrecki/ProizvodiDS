
package hr.obskc.proizvodids;

public class Proizvod {
    
    public static final int DEFAULT_KOLICINA=0;
    private static int proizvodCount=0;
    
    private final String kod;
    private String proizvod;
    private double cijena;
    private int kolicina;
    
    public Proizvod(String proizvod, double cijena, int kolicina) {
        setProizvod(proizvod);
        setCijena(cijena);
        checkCount(kolicina);
        this.kolicina=kolicina;
        
        proizvodCount++;
        
        this.kod="P"+String.format("%03d", proizvodCount);
        
    }
    
     public Proizvod(String proizvod, double cijena) {
        this(proizvod, cijena, DEFAULT_KOLICINA);
    }

     
    // getter
     public int getKolicina() {
        return kolicina;
    }
    public String getKod() {
        return kod;
    }

    public String getProizvod() {
        return proizvod;
    }

    public double getCijena() {
        return cijena;
    }

    public static int getProizvodBroj() {
        return proizvodCount;
    }

    // setter
    public void setProizvod(String proizvod) {
        if (proizvod == null || proizvod.isBlank()) {
            throw new IllegalArgumentException("Proizvod ne smije biti neimenovan.");
        }

        this.proizvod = proizvod.strip();
    }

    public void setCijena(double cijena) {
        if (cijena < 0) {
            throw new IllegalArgumentException("Cijena proizvoda ne može biti negativna.");
        }

        this.cijena = cijena;
    }
    
    public void dodaj(int kol) {
        if (kol <= 0) {
            throw new IllegalArgumentException("Broj dodanih proizvoda mora biti veći od 0.");
        }
        kolicina += kol;
    }

    public void prodaj(int kol) {
        if (kol <= 0 || kol > kolicina) {
            throw new IllegalArgumentException("Neispravan broj prodanih proizvoda.");
        }
        kolicina -= kol;
    }
    
    

    //samostalna validacijska metoda
    private void checkCount(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Količina proizvoda ne može biti manja od 0.");
        }
    }

     public double ukupnaVrijednost() {
        return cijena * kolicina;
    }
    
     public double ukupnaVrijednost(double popust) {
        if (popust < 0 || popust > 100) {
            throw new IllegalArgumentException("Popust mora biti između 0 i 100");
        }
        return ukupnaVrijednost() * (1-popust/100);
     }
    
    
    public String opis() {
        return kod + " | " + proizvod + " | " + String.format("%.2f", cijena) + " EUR | "
                + kolicina + " kom. ";
    }
    
    public boolean isProizvod(String proizvod) {
        return proizvod.equalsIgnoreCase(proizvod.strip());
    }
    
     public static int getproizvodCount() {
        return proizvodCount;
    }
     
     public static boolean isValidKod(String kod) {
        if (kod == null || kod.length() != 4 || !kod.startsWith("P")) {
            return false;
        }
    
    for (int i = 1; i < kod.length(); i++) {
            if (!Character.isDigit(kod.charAt(i))) {
                return false;
            }
        }
        
     return true;
    }
     
}
   

    

        
