import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalShips = 0;
        while (totalShips < 1 || totalShips > 25) {
            try {
            System.out.print("Podaj liczbę statków (maksymalnie 25): ");
            totalShips = scanner.nextInt();
            } catch (InputMismatchException e) {
            System.out.println("Nie no źle.");
            scanner.nextLine();
            }
        }

        GameLogic game = new GameLogic(totalShips);

        System.out.println("Witaj w grze w statki!");

        while (!game.isGameOver()) {
            game.printBoard();
            System.out.println("Podaj współrzędne (np. A2): ");
            String input = scanner.next().toUpperCase().trim();
            char colChar = input.charAt(0);
            int col = colChar - 'A';
            int row;
            try {
                row = Integer.parseInt(input.substring(1)) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format. Spróbuj ponownie.");
                continue;
            }
            game.shoot(row, col);
        }

        game.printBoard();
        System.out.println("Koniec gry!");

        scanner.close();
    }
}

