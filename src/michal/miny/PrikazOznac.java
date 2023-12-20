package michal.miny;

public class PrikazOznac extends SuradnicovyPrikaz {

    public PrikazOznac(int riadok, int stlpec) {
        super(riadok, stlpec);
    }

    @Override
    public void vykonaj(HraMiny hra) {
        hra.oznac(this.getRiadok(), this.getStlpec());
    }
}
