package michal.miny;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pozicia> miny = new ArrayList<Pozicia>();
        miny.add(new Pozicia(1, 1));
        miny.add(new Pozicia(2, 3));
        miny.add(new Pozicia(3, 0));

        HraMiny hra = new HraMiny(4, 9, miny);
        hra.debugPrint();

    }
}
