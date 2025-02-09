import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];  // Stores the row position of the queen in each column
        solveNQueens(0, board, n, result);
        return result;
    }

    private void solveNQueens(int col, int[] board, int n, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {  // All columns are filled, store the result
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1);  // Convert 0-based to 1-based index
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in each row for the current column
        for (int row = 0; row < n; row++) {
            if (isValid(board, col, row)) {
                board[col] = row;  // Place the queen
                solveNQueens(col + 1, board, n, result);
            }
        }
    }

    private boolean isValid(int[] board, int col, int row) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];

            // Check for same row or same diagonal
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
