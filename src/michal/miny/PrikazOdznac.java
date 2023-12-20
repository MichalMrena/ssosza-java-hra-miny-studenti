package michal.miny;

public class PrikazOdznac extends SuradnicovyPrikaz {

    public PrikazOdznac(int riadok, int stlpec) {
        super(riadok, stlpec);
    }

    @Override
    public void vykonaj(HraMiny hra) {
        hra.odznac(this.getRiadok(), this.getStlpec());
    }
}
