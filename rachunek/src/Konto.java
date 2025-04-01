class Konto extends Rachunek {
    protected static double oprocentowanie = 0.0;

    public Konto(Osoba wlasciciel, double stan) {
        super(wlasciciel, stan);
    }

    public static void zmienOprocentowanie(double noweOprocentowanie) {
        oprocentowanie = noweOprocentowanie;
    }

    @Override
    public void aktualizacja() {
        stan += stan * (oprocentowanie / 100);
    }

    @Override
    public String toString() {
        return "Konto właściciela: " + wlasciciel.toString() +
                ", stan: " + stan + ", oprocentowanie: " + oprocentowanie + "%";
    }
}