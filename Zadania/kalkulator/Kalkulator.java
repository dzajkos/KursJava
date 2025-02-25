import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult = 0;
        boolean continueCalculator = true;

        while (continueCalculator) {
            double num1 = 0, num2 = 0;
            char operator = ' ';

            while (continueCalculator) {
                System.out.print("Podaj pierwszą liczbę: ");
                try {
                    num1 = scanner.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Błędne dane! Wprowadź liczbę.");
                    scanner.next();
                }
            }

            while (continueCalculator) {
                System.out.print("Podaj operator (+, -, *, /, %, ^): ");
                String operatorInput = scanner.next();
                if (operatorInput.length() == 1) {
                    operator = operatorInput.charAt(0);
                    if (operator == '+' || operator == '-' || operator == '*' ||
                            operator == '/' || operator == '%' || operator == '^') {
                        break;
                    }
                }
                System.out.println("Błędny operator! Spróbuj ponownie.");
            }

            while (continueCalculator) {
                System.out.print("Podaj drugą liczbę: ");
                try {
                    num2 = scanner.nextDouble();
                    if ((operator == '/' || operator == '%') && num2 == 0) {
                        System.out.println("Nie można dzielić przez zero. Podaj inną liczbę.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Błędne dane! Wprowadź liczbę.");
                    scanner.next();
                }
            }

            switch (operator) {
                case '+':
                    lastResult = num1 + num2;
                    break;
                case '-':
                    lastResult = num1 - num2;
                    break;
                case '*':
                    lastResult = num1 * num2;
                    break;
                case '/':
                    lastResult = num1 / num2;
                    break;
                case '%':
                    lastResult = num1 % num2;
                    break;
                case '^':
                    lastResult = Math.pow(num1, num2);
                    break;
                default:
                    System.out.println("Nieznany operator.");
                    continue;
            }

            System.out.println("Wynik: " + lastResult);

            System.out.print("Czy chcesz wykonać kolejne działanie? (y/n): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                continueCalculator = false;
            }
        }


        if (lastResult % 1 == 0) {
            System.out.println("Ostatni wynik jest liczbą całkowitą.");
            System.out.println(lastResult % 2 == 0 ? "Ostatni wynik jest parzysty." : "Ostatni wynik jest nieparzysty.");
        } else {
            System.out.println("Ostatni wynik nie jest liczbą całkowitą więc jest również nieparzysty.");
        }
       // System.out.println(lastResult % 2 == 0 ? "Ostatni wynik jest parzysty." : "Ostatni wynik jest nieparzysty.");
       // System.out.println(lastResult % 1 == 0 ? "Ostatni wynik jest liczbą całkowitą" : "Ostatni wynik nie jest liczbą całkowitą.");
        System.out.println(lastResult >= 0 ? "Ostatni wynik jest dodatni." : "Ostatni wynik jest ujemny.");

        scanner.close();
    }
}
