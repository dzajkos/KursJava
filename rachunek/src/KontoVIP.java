class KontoVIP extends Konto {
    private final double indywidualneOprocentowanie;
    private final double limitDebetu;

    public KontoVIP(Osoba wlasciciel, double stan, double indywidualneOprocentowanie, double limitDebetu) {
        super(wlasciciel, stan);
        this.indywidualneOprocentowanie = indywidualneOprocentowanie;
        this.limitDebetu = limitDebetu;
    }

    @Override
    public boolean wyplata(double kwota) {
        if (kwota > 0 && (stan - kwota >= limitDebetu)) {
            stan -= kwota;
            return true;
        }
        return false;
    }

    @Override
    public boolean przelew(Rachunek innyRachunek, double kwota) {
        if (this.wyplata(kwota)) {
            innyRachunek.wplata(kwota);
            return true;
        }
        return false;
    }

    @Override
    public void aktualizacja() {
        stan += stan * (indywidualneOprocentowanie / 100);
    }

    @Override
    public String toString() {
        return "KontoVIP właściciela: " + wlasciciel.toString() +
                ", stan: " + stan + ", indywidualne oprocentowanie: " + indywidualneOprocentowanie +
                "%, limit debetu: " + limitDebetu;
    }
}