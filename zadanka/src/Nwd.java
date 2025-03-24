public class Nwd {

    public static double nwd(double a, double b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(nwd(8, 40));
    }

}
