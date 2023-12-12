package michal.miny;

public class PrikazOdkry implements IPrikaz {
    private final int riadok;
    private final int stlpec;

    public PrikazOdkry(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    @Override
    public void vykonaj(HraMiny hra) {
        hra.odkry(this.riadok, this.stlpec);
    }
}
