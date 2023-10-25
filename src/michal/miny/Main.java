package michal.miny;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pozicia> miny = new ArrayList<Pozicia>();
        miny.add(new Pozicia(3, 5));
        miny.add(new Pozicia(0, 0));
        miny.add(new Pozicia(1, 2));

        HraMiny hra = new HraMiny(4, 8, miny);

        System.out.println("askdbaksbnd");
    }
}
