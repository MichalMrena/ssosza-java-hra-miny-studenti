package michal.miny;

public class KonzolovyZobrazovacHry {
    public void zobraz(HraMiny hra) {

        for (int riadok = 0; riadok < hra.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < hra.getPocetStlpcov(); stlpec++) {
                IPopisPolicka policko = hra.getPolicko(riadok, stlpec);

                if (policko.jeOznacene()) {
                    System.out.print("f");
                } else if (!policko.jeOdkryte()) {
                    System.out.print("#");
                } else if (policko.maMinu()) {
                    System.out.print("x");
                } else if (policko.getPocetMinVOkoli() > 0) {
                    System.out.print(policko.getPocetMinVOkoli());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
