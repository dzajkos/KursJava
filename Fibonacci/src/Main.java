import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static long fibonacci (int n) {

       return fibonacciRecursive(n, 0, 1);
    }

    private static long fibonacciRecursive (int n, long a, long b) {
        if (n == 0) return a;
        if (n == 1) return b;
        return fibonacciRecursive(n-1, b, a+b);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 55; i++) {
            System.out.println(i + " - " + fibonacci(i));

        }
    }

}
