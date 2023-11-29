package michal.miny;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pozicia> miny = new ArrayList<Pozicia>();
        miny.add(new Pozicia(1, 1));
        miny.add(new Pozicia(2, 3));
        miny.add(new Pozicia(3, 0));

        Scanner scanner = new Scanner(System.in);
        HraMiny hra = new HraMiny(4, 9, miny);
        KonzolovyZobrazovacHry zobrazovac = new KonzolovyZobrazovacHry();
        ParserPrikazov parser = new ParserPrikazov();
        zobrazovac.zobraz(hra);

        while (hra.getStavHry() == StavHry.PREBIEHA) {
            System.out.print("> ");
            String vstup = scanner.nextLine();
            IPrikaz prikaz = parser.parsujPrikaz(vstup);
            if (prikaz != null) {
                prikaz.vykonaj(hra);
                zobrazovac.zobraz(hra);
            } else {
                System.out.println("Nespravny prikaz!");
            }
        }
    }
}
