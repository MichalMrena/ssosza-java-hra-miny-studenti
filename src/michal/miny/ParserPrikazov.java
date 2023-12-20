package michal.miny;

public class ParserPrikazov {
    public IPrikaz parsuj(String vstup) {
        // "odkry 0 0"
        // "oznac 0 0"
        // "odznac 0 0"
        // "ukonci"

        String[] tokeny = vstup.split(" ");
        switch (tokeny[0]) {
            case "odkry": {
                if (tokeny.length < 3) {
                    return null;
                }
                int[] pozicia = this.parsujPoziciu(tokeny[1], tokeny[2]);
                if (pozicia == null) {
                    return null;
                }
                return new PrikazOdkry(pozicia[0], pozicia[1]);
            }

            case "oznac": {
                if (tokeny.length < 3) {
                    return null;
                }
                int[] pozicia = this.parsujPoziciu(tokeny[1], tokeny[2]);
                if (pozicia == null) {
                    return null;
                }
                return new PrikazOznac(pozicia[0], pozicia[1]);
            }

            case "odznac": {
                if (tokeny.length < 3) {
                    return null;
                }
                int[] pozicia = this.parsujPoziciu(tokeny[1], tokeny[2]);
                if (pozicia == null) {
                    return null;
                }
                return new PrikazOdznac(pozicia[0], pozicia[1]);
            }

            case "ukonci":
                return new PrikazUkonci();

            default:
                return null;
        }
    }

    private int[] parsujPoziciu(String prvy, String druhy) {
        try {
            int riadok = Integer.parseInt(prvy);
            int stlpec = Integer.parseInt(druhy);
            return new int[]{riadok, stlpec};
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
