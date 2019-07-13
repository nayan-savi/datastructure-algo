package queen;

public class NQueenProblem {

    static int N = 16;
    static int[][] board = new int[N][N];

    public static void fillPositions(int[][] board, int row, int col) {
        int i, j;
        // queen place
        // for col left and right && row up and down
        for (i = col - 1, j = col + 1; i >= 0 || j < N; i--, j++) {
            if (i >= 0) {
                board[row][i] = 1;
                board[i][col] = 1;
            }
            if (j < N) {
                board[row][j] = 1;
                board[j][col] = 1;
            }
        }
        // diagonal upper right
        for (i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            board[i][j] = 1;
        }
        // diagonal lower left
        for (i = row + 1, j = col - 1; i < N && j >= 0; i++, j--) {
            board[i][j] = 1;
        }

        // diagonal upper left
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            board[i][j] = 1;
        }

        // diagonal lower right
        for (i = row + 1, j = col + 1; i < N && j < N; i++, j++) {
            board[i][j] = 1;
        }
    }

    public static void main(String[] args) {
        int xQ = 5, yQ = 5;
        board[xQ][yQ] = 2;
        fillPositions(board, xQ, yQ);
        System.out.println();
        display();
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
