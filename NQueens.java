import java.util.Scanner;

public class NQueens {
    private static int[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Queens: ");
        int n = scanner.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }

        boolean res = solve(n, 0);
        if (!res) {
            System.out.println(-1);
        }
        scanner.close();
    }

    private static boolean solve(int n, int row) {
        if (n == row) {
            print(n);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < n; i++) {
            if (isSafe(i, row, n)) {
                grid[row][i] = 1;

                res = solve(n, row + 1) || res;

                grid[row][i] = 0;
            }
        }
        return res;
    }

    private static boolean isSafe(int col, int row, int n) {
        for (int i = 0; i < row; i++) {
            if (grid[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
