package michal.miny;

public abstract class SuradnicovyPrikaz implements IPrikaz {
    private final int riadok;
    private final int stlpec;

    protected SuradnicovyPrikaz(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    protected int getRiadok() {
        return this.riadok;
    }

    protected int getStlpec() {
        return this.stlpec;
    }

    public abstract void vykonaj(HraMiny hra);
}
