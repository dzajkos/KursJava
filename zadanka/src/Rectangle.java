public class Rectangle {

    public void printRectangle (int a, int b) {
        for (int i = 1; i < a+1; i++) {
            if (i == 1 || i == a) {
                for (int j = 0; j < b+1; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.println("");
                for (int j = 0; j < b+1; j++) {
                    if(j == 1 || j == b) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

        }
    }

    public void printRectangle2 (int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || i == a-1 || j == 0 || j == b-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        rectangle.printRectangle2(6, 8);
    }
}
