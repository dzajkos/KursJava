public class CzyPierwsza {

    public static boolean IsPrimary (int a) {
        if (a < 2) {
            return true;
        }
        for (int i = 2; i * i <= a ; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPrimary(5));
    }

}
