import java.util.Random;

public class LosowaTablica {

    static int[] tab = new int[20];
    static Random random = new Random();
    static int maxNumber = 80;

    public static void fillWithRandom(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(maxNumber);
        }
    }
    public static int findBiggest(int[] tab) {
        int biggest = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > biggest) {
                biggest = tab[i];
            }
        }
        return biggest;
    }
    public static int findSmallest(int[] tab) {
        int lowest = maxNumber;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] < lowest) {
                lowest = tab[i];
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        fillWithRandom(tab);
        System.out.println(findBiggest(tab));
        System.out.println(findSmallest(tab));
    }


}
