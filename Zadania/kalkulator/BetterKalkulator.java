import java.util.InputMismatchException;
import java.util.Scanner;

public class BetterKalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lastResult = 0;
        boolean continueCalculator = true;

        while (continueCalculator) {
            double num1 = 0, num2 = 0;
            char operator = ' ';
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Podaj działanie (np. 10 + 15): ");
                String inputLine = scanner.nextLine();
                String[] tokens = inputLine.trim().split("\\s+");

                if (tokens.length != 3) {
                    System.out.println("Błędne dane. Upewnij się, że wpisujesz: liczba operator liczba.");
                    continue;
                }
                try {
                    num1 = Double.parseDouble(tokens[0]);
                    operator = tokens[1].charAt(0);
                    num2 = Double.parseDouble(tokens[2]);

                    // Sprawdzenie czy operator jest poprawny
                    if (!(operator == '+' || operator == '-' || operator == '*' ||
                            operator == '/' || operator == '%' || operator == '^')) {
                        System.out.println("Błędny operator! Dostępne: +, -, *, /, %, ^.");
                        continue;
                    }
                    // Dla dzielenia i modulo sprawdzenie dzielnika
                    if ((operator == '/' || operator == '%') && num2 == 0) {
                        System.out.println("Nie można dzielić przez zero. Podaj działanie jeszcze raz.");
                        continue;
                    }
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Błędne dane liczby. Spróbuj ponownie.");
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
