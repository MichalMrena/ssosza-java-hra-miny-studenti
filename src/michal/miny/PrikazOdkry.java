package michal.miny;

public class PrikazOdkry implements IPrikaz {

    private int riadok;
    private int stlpec;

    public PrikazOdkry(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    public void vykonaj(HraMiny hra) {
        hra.odkry(this.riadok, this.stlpec);
    }
}
