package michal.miny;

public class Policko implements IPopisPolicka {

    private boolean jeOdkryte;
    private boolean jeOznacene;
    private boolean maMinu;
    private int pocetMinVOkoli;

    public Policko(boolean maMinu, int pocetMinVOkoli) {
        this.maMinu = maMinu;
        this.pocetMinVOkoli = pocetMinVOkoli;
        this.jeOdkryte = false;
        this.jeOznacene = false;
    }

    public void odkrySa() {
        this.jeOdkryte = true;
    }

    public void oznacSa() {
        this.jeOznacene = true;
    }

    public void odznacSa() {
        this.jeOznacene = false;
    }

    public boolean jeOdkryte() {
        return this.jeOdkryte;
    }

    public boolean jeOznacene() {
        return this.jeOznacene;
    }

    public boolean maMinu() {
        return this.maMinu;
    }

    public int getPocetMinVOkoli() {
        return this.pocetMinVOkoli;
    }
}










