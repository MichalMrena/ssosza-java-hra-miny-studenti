package michal.miny;

import java.util.ArrayList;

/**
 * Toto je hracia plocha.
 */
public class HraMiny {

    private Policko[][] policka;

    public HraMiny(int pocetRiadkov, int pocetStlpcov, ArrayList<Pozicia> miny) {

        this.policka = new Policko[pocetRiadkov][pocetStlpcov];

        for (int riadok = 0; riadok < pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < pocetStlpcov; stlpec++) {
                boolean jeTamMina = this.obsahujeMinu(miny, riadok, stlpec);
                this.policka[riadok][stlpec] = new Policko(jeTamMina, -1);
            }
        }
    }

    public boolean obsahujeMinu(ArrayList<Pozicia> miny, int riadok, int stlpec) {
        for (Pozicia pozicia : miny) {
            if (pozicia.jeRovnaka(riadok, stlpec)) {
                return true;
            }
        }
        return false;
    }

}










