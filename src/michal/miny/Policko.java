package michal.miny;

public class Policko {

    private boolean maMinu;
    private int pocetMinVOkoli;
    private boolean jeOdkryte;
    private boolean jeOznacene;

    public Policko(boolean maMinu, int pocetMinVOkoli) {
        this.maMinu = maMinu;
        this.pocetMinVOkoli = pocetMinVOkoli;
        this.jeOdkryte = false;
        this.jeOznacene = false;
    }

    public void odkry() {
        this.jeOdkryte = true;
    }

    public boolean obsahujeMinu() {
        return this.maMinu;
    }

    public void oznac() {
        this.jeOznacene = true;
    }

    public void odznac() {
        this.jeOznacene = false;
    }

    public int getPocetMinVOkoli() {
        return this.pocetMinVOkoli;
    }

    public boolean jeOdkryte() {
        return this.jeOdkryte;
    }

    public boolean jeOznacene() {
        return this.jeOznacene;
    }
}








