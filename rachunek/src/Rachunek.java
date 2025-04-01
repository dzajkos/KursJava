class Rachunek {
    protected Osoba wlasciciel;
    protected double stan;

    public Rachunek(Osoba wlasciciel, double stan) {
        this.wlasciciel = wlasciciel;
        this.stan = stan;
    }

    public boolean wplata(double kwota) {
        if (kwota > 0) {
            stan += kwota;
            return true;
        }
        return false;
    }

    public boolean wyplata(double kwota) {
        if (kwota > 0 && stan >= kwota) {
            stan -= kwota;
            return true;
        }
        return false;
    }

    public boolean przelew(Rachunek innyRachunek, double kwota) {
        if (this.wyplata(kwota)) {
            innyRachunek.wplata(kwota);
            return true;
        }
        return false;
    }

    public void aktualizacja() {
        System.out.println("Rachunek podstawowy");
    }

    @Override
    public String toString() {
        return "Rachunek właściciela: " + wlasciciel.toString() + ", stan: " + stan;
    }
}