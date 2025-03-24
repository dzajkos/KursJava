public class Piramidka {

    public static void printPiramidka (int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i -1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i +1; j++) {
                if (i == height - 1 || j == 0 || j == 2 * i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPiramidka(6);
    }

}
