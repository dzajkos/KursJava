import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private static final char[][] BOARD = new char[SIZE][SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                BOARD[i][j] = '-';
            }
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < SIZE * SIZE) {
            printBoard();
            System.out.println("Gracz " + currentPlayer + ", wpisz rząd (0-2): ");
            int row = scanner.nextInt();
            System.out.println("Gracz " + currentPlayer + ", wpisz kolumnę (0-2): ");
            int col = scanner.nextInt();

            if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && BOARD[row][col] == '-') {
                BOARD[row][col] = currentPlayer;
                moves++;

                if (checkWin()) {
                    gameWon = true;
                    printBoard();
                    System.out.println("Gracz " + currentPlayer + " wygrywa!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Niepoprawny ruch!");
            }
        }

        if (!gameWon) {
            printBoard();
            System.out.println("Remis!");
        }
        scanner.close();
    }

    private static void printBoard() {
        for (char[] row : BOARD) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            if (allEqual(BOARD[i]) || allEqual(new char[]{BOARD[0][i], BOARD[1][i], BOARD[2][i]})) {
                return true;
            }
        }
        return allEqual(new char[]{BOARD[0][0], BOARD[1][1], BOARD[2][2]}) ||
                allEqual(new char[]{BOARD[0][2], BOARD[1][1], BOARD[2][0]});
    }

    private static boolean allEqual(char[] line) {
        return line[0] != '-' && line[0] == line[1] && line[1] == line[2];
    }
}
