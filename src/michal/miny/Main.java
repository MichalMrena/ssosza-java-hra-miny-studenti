package michal.miny;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pozicia> miny = new ArrayList<Pozicia>();
        miny.add(new Pozicia(2, 1));
        miny.add(new Pozicia(0, 0));
        miny.add(new Pozicia(0, 3));

        HraMiny hra = new HraMiny(4, 9, miny);

        System.out.println("funguje to");
    }
}
