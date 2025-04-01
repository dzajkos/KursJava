public class Main {
    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("Karol", "Wojtyła");
        Osoba osoba2 = new Osoba("Sebastian", "Psikuta");
        Osoba osoba3 = new Osoba("Robert", "Kubica");

        Rachunek rach1 = new Rachunek(osoba1, 1000);
        Konto konto1 = new Konto(osoba2, 2000);
        KontoVIP kontoVIP1 = new KontoVIP(osoba3, 3000, 2.5, -500);

        Rachunek[] rachunki = new Rachunek[3];
        rachunki[0] = rach1;
        rachunki[1] = konto1;
        rachunki[2] = kontoVIP1;

        System.out.println("=== Operacje ===");
        System.out.println("Wpłata 500 do rach1: " + rach1.wplata(500));
        System.out.println("Wypłata 1000 z konto1: " + konto1.wyplata(1000));
        System.out.println("Przelew 200 z kontoVIP1 do rach1: " + kontoVIP1.przelew(rach1, 200));
        Konto.zmienOprocentowanie(5.0);

        System.out.println("\n=== Stany przed aktualizacją ===");
        for (Rachunek r : rachunki) {
            System.out.println(r.toString());
        }

        System.out.println("\n=== Aktualizacja rachunków ===");
        for (Rachunek r : rachunki) {
            r.aktualizacja();
        }

        System.out.println("\n=== Stany po aktualizacji ===");
        for (Rachunek r : rachunki) {
            System.out.println(r.toString());
        }
    }
}