package michal.miny;

public class ParserPrikazov {

    public IPrikaz parsujPrikaz(String vstup) {

        // "odkry 3 8"

        String[] tokeny = vstup.split(" ");
        if (tokeny.length < 3) {
            return null;
        }

        if (!tokeny[0].equals("odkry")) {
            return null;
        }

        try {
            int riadok = Integer.parseInt(tokeny[1]);
            int stlpec = Integer.parseInt(tokeny[2]);
            return new PrikazOdkry(riadok, stlpec);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
