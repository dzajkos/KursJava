import java.util.Scanner;

public class BetterCalculator {

        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            Logic2 logic = new Logic2();
            double lastResult;

            while (true) {

                logic.getInputAndValidate(scanner);

                lastResult = logic.calculate();

                logic.printResult(lastResult);

                System.out.println("Czy chcesz wykonać kolejne działanie? (y/n): ");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("n")) {
                    break;
                }
                scanner.nextLine();
            }
            logic.identifyResult(lastResult);
            scanner.close();
        }
}
