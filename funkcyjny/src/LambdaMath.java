public class LambdaMath {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> b != 0 ? a / b : Double.NaN;

        System.out.println(calculate(8, 0, division));

    }

    private static double calculate (double a, double b, MathOperation operation) {
        return operation.math(a, b);
    }
}
