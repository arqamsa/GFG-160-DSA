
// User function Template for Java
class Solution {
    // Function to solve the Sudoku puzzle.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat);
    }
    private static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {  
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; 
                            if (solve(board)) {
                                return true;  
                            }
                            board[row][col] = 0;  
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == num) {
                return false;
            }
        }
        return true;
    }
    static void printGrid(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
