package michal.miny;

import java.util.ArrayList;

/**
 * Reprezentuje hracie pole.
 * @author Michal
 * @version 1.0.0
 */
public class HraMiny {

    private Policko[][] policka;

    public HraMiny(int pocetRiadkov, int pocetStlpcov, ArrayList<Pozicia> miny) {
        this.policka = new Policko[pocetRiadkov][pocetStlpcov];
        for (int riadok = 0; riadok < pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < pocetStlpcov; stlpec++) {
                boolean jeTamMina = this.obsahujeMinu(riadok, stlpec, miny);
                this.policka[riadok][stlpec] = new Policko(jeTamMina, -1);
            }
        }
    }

    public boolean obsahujeMinu(int riadok, int stlpec, ArrayList<Pozicia> miny) {
        for (Pozicia pozicia : miny) {
            if (pozicia.jeRovnaka(riadok, stlpec)) {
                return true;
            }
        }
        return false;
    }
}








