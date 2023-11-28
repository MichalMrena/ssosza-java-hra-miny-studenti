package michal.miny;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pozicia> miny = new ArrayList<Pozicia>();
        miny.add(new Pozicia(1, 2));
        miny.add(new Pozicia(2, 0));
        miny.add(new Pozicia(3, 3));

        HraMiny hra = new HraMiny(4, 9, miny);
        KonzolovyZobrazovacHry zobrazovac = new KonzolovyZobrazovacHry();
        hra.odkry(0,0);
        hra.odkry(3,8);
        zobrazovac.zobraz(hra);
    }
}
