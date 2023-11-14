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
                int pocetMinVOkoli = this.spocitajMinyVOkoli(riadok, stlpec, miny);
                this.policka[riadok][stlpec] = new Policko(jeTamMina, pocetMinVOkoli);
            }
        }
    }

    public int getPocetRiadkov() {
        return this.policka.length;
    }

    public int getPocetStlpcov() {
        return this.policka[0].length;
    }

    public void debugPrint() {
        for (int riadok = 0; riadok < this.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < this.getPocetStlpcov(); stlpec++) {
                Policko policko = this.policka[riadok][stlpec];
//                policko.maMinu()
//                policko.getPocetMinVOkoli()
            }
            System.out.println();
        }
    }

    private int spocitajMinyVOkoli(int riadok, int stlpec, ArrayList<Pozicia> miny) {
        int pocet = 0;
        for (int dr = -1; dr < 2; dr++) {
            for (int ds = -1; ds < 2; ds++) {
                if (dr == 0 && ds == 0) {
                    continue;
                }

                int susednyRiadok = riadok + dr;
                int susednyStlpec = stlpec + ds;

                if (!this.jeVHracomPoli(susednyRiadok, susednyStlpec)) {
                    continue;
                }

                if (this.obsahujeMinu(susednyRiadok, susednyStlpec, miny)) {
                    ++pocet;
                }
            }
        }
        return pocet;
    }

    private boolean jeVHracomPoli(int riadok, int stlpec) {
        return riadok >= 0 &&
               stlpec >= 0 &&
               riadok < this.getPocetRiadkov() &&
               stlpec < this.getPocetStlpcov();
    }

    private boolean obsahujeMinu(int riadok, int stlpec, ArrayList<Pozicia> miny) {
        for (Pozicia pozicia : miny) {
            if (pozicia.jeRovnaka(riadok, stlpec)) {
                return true;
            }
        }
        return false;
    }
}








