package michal.miny;

public class Main {
    public static void main(String[] args) {
        Policko prve = new Policko(true, 7);
        Policko druhe = new Policko(true, 7);

        Policko tretie = prve;

        if (prve == tretie) {
            System.out.println("Su rovnake.");
        }

        if (prve == druhe) {
            System.out.println("Aj tieto su rovnake.");
        }
    }
}
