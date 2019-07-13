package queen;

import java.util.ArrayList;
import java.util.List;

public class QueenSteps {

    static int N = 8;
    static char[][] board = new char[N][N];

    static class Obstacle {
        int row;
        int col;

        public Obstacle(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int countQueenSteps(char[][] board, int row, int col) {
        int i, j;
        int count = 0;
        // queen place
        // for col left and right && row up and down
        for (i = col - 1; i >= 0; i--) {
            if (board[row][i] == 'X') break;
            board[row][i] = '.';
            count++;
        }

        for (j = col + 1; j < N; j++) {
            if (board[row][j] == 'X') break;
            board[row][j] = '.';
            count++;
        }

        for (i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'X') break;
            board[i][col] = '.';
            count++;
        }

        for (j = row + 1; j < N; j++) {
            if (board[j][col] == 'X') break;
            board[j][col] = '.';
            count++;
        }
        // diagonal upper right
        for (i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'X') break;
            board[i][j] = '.';
            count++;
        }
        // diagonal lower left
        for (i = row + 1, j = col - 1; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 'X') break;
            board[i][j] = '.';
            count++;
        }

        // diagonal upper left
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'X') break;
            board[i][j] = '.';
            count++;
        }

        // diagonal lower right
        for (i = row + 1, j = col + 1; i < N && j < N; i++, j++) {
            if (board[i][j] == 'X') break;
            board[i][j] = '.';
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int rowQ = 4;
        int colQ = 5;
        init();
        board[rowQ][colQ] = 'Q';
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(0, 5));
        obstacles.add(new Obstacle(1, 2));
        obstacles.add(new Obstacle(2, 7));
        obstacles.add(new Obstacle(3, 1));
        obstacles.add(new Obstacle(4, 3));
        obstacles.add(new Obstacle(5, 6));
        obstacles.add(new Obstacle(6, 5));
        for (Obstacle obstacle : obstacles) {
            board[obstacle.row][obstacle.col] = 'X';
        }
        int out = countQueenSteps(board, rowQ, colQ);
        display();
        System.out.println(out);

    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }
    }
}
