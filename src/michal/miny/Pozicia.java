package michal.miny;

public class Pozicia {

    private int riadok;
    private int stlpec;

    public Pozicia(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    public int getRiadok() {
        return this.riadok;
    }

    public int getStlpec() {
        return this.stlpec;
    }

    public boolean jeRovnaka(Pozicia ina) {
        return this.riadok == ina.getRiadok() && this.stlpec == ina.getStlpec();
    }

    public boolean jeRovnaka(int riadok, int stlpec) {
        return this.riadok == riadok && this.stlpec == stlpec;
    }
}









