package michal.miny;

public class PrikazOdkry extends SuradnicovyPrikaz {

    public PrikazOdkry(int riadok, int stlpec) {
        super(riadok, stlpec);
    }

    @Override
    public void vykonaj(HraMiny hra) {
        hra.odkry(this.getRiadok(), this.getStlpec());
    }
}
