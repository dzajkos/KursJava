import java.util.List;
import java.util.stream.IntStream;

public class GameLogic {
    private char[][] board;
    private boolean[][] hits;
    private boolean[][] ships;
    private int shipsLeft;
    private int totalShips;
    private List<Integer> possiblePositions;
    private int size = 5; // po 26 alfabet się kończy XD

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public GameLogic(int totalShips) {
        board = new char[size][size];
        hits = new boolean[size][size];
        ships = new boolean[size][size];
        this.totalShips = totalShips;
        shipsLeft = totalShips;
        possiblePositions = IntStream.range(0, size).boxed().toList();
        initBoard();
    }


    private void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '■';
                hits[i][j] = false;
                ships[i][j] = false;
            }
        }

        int placed = 0;
        while (placed < totalShips) {
            int r = (int) (Math.random() * size);
            int c = (int) (Math.random() * size);
            if (!ships[r][c]) {
                ships[r][c] = true;
                placed++;
            }
        }
    }

    public boolean shoot(int row, int col) {
       // if (row < 0 || row >= 5 || col < 0 || col >= 5) {
        if (!possiblePositions.contains(row) || !possiblePositions.contains(col)) {
                System.out.println("Strzał poza planszą!");
                return false;
            }

        if (hits[row][col]) {
            System.out.println("To pole już było strzelane!");
            return false;
        }
        hits[row][col] = true;
        if (ships[row][col]) {
            board[row][col] = '⊞';
            shipsLeft--;
            System.out.println("Trafiony!");
            if (shipsLeft == 0) {
                System.out.println("Wszystkie statki zatopione!");
            }
            return true;
        } else {
            board[row][col] = '□';
            System.out.println("Pudło!");
            return false;
        }
    }

    public boolean isGameOver() {
        return shipsLeft == 0;
    }

    public void printBoard() {
        System.out.print("   ");
        char c = 'A';
        for (int i = 0; i < size; i++) {
            System.out.print(c + " ");
            c++;
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
