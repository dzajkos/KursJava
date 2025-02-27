import java.util.List;
import java.util.Scanner;
import static java.lang.Double.NEGATIVE_INFINITY;

public class Logic2 {

   private double num1 = 0, num2 = 0;
   private char operator = ' ';

   private double division(double a, double b, char c) {
        if (b == 0) {
            System.out.println("\u001B[31m" + "nie można dzielić przez zero" + "\u001B[0m");
            return NEGATIVE_INFINITY;
        } else {
           return switch (c) {  case '/' -> a / b;
                                case '%' -> a % b;
                                default -> 0; };
        }
    }

   public void identifyResult (double lastResult) {
        if (lastResult % 1 == 0) {
            System.out.println("Ostatni wynik jest liczbą całkowitą.");
            System.out.println(lastResult % 2 == 0 ? "Ostatni wynik jest parzysty." : "Ostatni wynik jest nieparzysty.");
        } else {
            System.out.println("Ostatni wynik nie jest liczbą całkowitą więc jest również nieparzysty.");
        }
        System.out.println(lastResult >= 0 ? "Ostatni wynik jest dodatni." : "Ostatni wynik jest ujemny.");
    }

   public void getInputAndValidate (Scanner scanner) {
        boolean validInput = false;
        List<Character> validOperators = List.of('+', '-', '*', '/', '%', '^');
        while (!validInput) {
            System.out.print("Podaj działanie (np. 4 + 6): ");
            String input = scanner.nextLine();
            String[] nums = input.trim().split("\\s+");
            if (nums.length != 3) {
                System.out.println("Błędne dane.");
                continue;
            }
            try {
                num1 = Double.parseDouble(nums[0]);
                operator = nums[1].charAt(0);
                num2 = Double.parseDouble(nums[2]);

                if (!validOperators.contains(operator)) { //todo: operatory przerobić na listę lub enumy.
                    System.out.println("Błędny operator. (+, -, *, /, %, ^).");
                    continue;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Błędne dane liczby. Spróbuj ponownie.");
            }
        }
    }

   public double calculate () {
        return switch (operator) { //todo: przerobić switcha na nowy
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> division(num1, num2, operator);
            case '%' -> division(num1, num2, operator);
            case '^' -> Math.pow(num1, num2);
            default -> num1;
        };
    }

   public void printResult (double lastResult) {
        if (lastResult != NEGATIVE_INFINITY) {
            System.out.println("Wynik: " + lastResult);
        }
    }
}
