package michal.miny;

import java.util.ArrayList;

/**
 * Reprezentuje hracie pole.
 * @author Michal
 * @version 1.0.0
 */
public class HraMiny {

    private Policko[][] policka;
    private StavHry stavHry;
    private int pocetNeodkrytych;

    public HraMiny(int pocetRiadkov, int pocetStlpcov, ArrayList<Pozicia> miny) {
        this.policka = new Policko[pocetRiadkov][pocetStlpcov];
        for (int riadok = 0; riadok < pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < pocetStlpcov; stlpec++) {
                boolean jeTamMina = this.obsahujeMinu(riadok, stlpec, miny);
                int pocetMinVOkoli = this.spocitajMinyVOkoli(riadok, stlpec, miny);
                this.policka[riadok][stlpec] = new Policko(jeTamMina, pocetMinVOkoli);
            }
        }

        this.stavHry = StavHry.PREBIEHA;
        this.pocetNeodkrytych = pocetRiadkov * pocetStlpcov - miny.size();
    }

    // TODO toto este nie je dobre lebo Policko sa da zvonku menit
    // TODO treba to opravit
    public Policko getPolicko(int riadok, int stlpec) {
        return this.policka[riadok][stlpec];
    }

    public int getPocetRiadkov() {
        return this.policka.length;
    }

    public int getPocetStlpcov() {
        return this.policka[0].length;
    }

    public void odkry(int riadok, int stlpec) {
        if (!this.jeVHracomPoli(riadok, stlpec)) {
            return;
        }

        if (this.stavHry != StavHry.PREBIEHA) {
            return;
        }

        Policko policko = this.policka[riadok][stlpec];
        if (policko.jeOdkryte() || policko.jeOznacene()) {
            return;
        }

        if (policko.maMinu()) {
            this.stavHry = StavHry.PREHRA;
            return;
        }

        this.odkryOkolieVratane(riadok, stlpec);

        if (this.pocetNeodkrytych == 0) {
            this.stavHry = StavHry.VYHRA;
        }
    }

    private void odkryOkolieVratane(int riadok, int stlpec) {
        ArrayList<Pozicia> pozicie = new ArrayList<Pozicia>();
        Pozicia prva = new Pozicia(riadok, stlpec);
        pozicie.add(prva);

        while (!pozicie.isEmpty()) {
            // vyber dalsiu poziciu a spristupni policko
            int index = pozicie.size() - 1;
            Pozicia pozicia = pozicie.get(index);
            pozicie.remove(index);
            Policko policko = this.policka[pozicia.getRiadok()][pozicia.getStlpec()];

            policko.odkrySa();
            this.pocetNeodkrytych--;

            if (policko.getPocetMinVOkoli() > 0) {
                continue;
            }

            // prehladaj okolie
            for (int dr = -1; dr < 2; dr++) {
                for (int ds = -1; ds < 2; ds++) {
                    if (dr == 0 && ds == 0) {
                        continue;
                    }

                    int susednyRiadok = pozicia.getRiadok() + dr;
                    int susednyStlpec = pozicia.getStlpec() + ds;

                    if (!this.jeVHracomPoli(susednyRiadok, susednyStlpec)) {
                        continue;
                    }

                    Policko susedne = this.policka[susednyRiadok][susednyStlpec];
                    if (!susedne.maMinu() && !susedne.jeOdkryte()) {
                        pozicie.add(new Pozicia(susednyRiadok, susednyStlpec));
                    }
                }
            }
        }
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








