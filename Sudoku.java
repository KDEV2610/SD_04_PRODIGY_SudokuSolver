public class Sudoku {

    // Function for 3x3 matrices -> Grid
    public boolean grid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char) (num + '0')) {
                return false;
            }
            if (board[i][col] == (char) (num + '0')) {
                return false;
            }
        }
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == (char) (num + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to solve Sudoku by rows and columns
    public boolean RowColoumn(char[][] board, int row, int column) {

        // New row and col
        int nRow = 0;
        int nCol = 0;

        // Check if we reached the end of the board
        if (row == board.length) {
            return true;
        }

        // Determine the next row and column
        if (column != board.length - 1) {
            nRow = row;
            nCol = column + 1;
        } else {
            nRow = row + 1;
            nCol = 0;
        }

        // If the cell is already filled, move to the next cell
        if (board[row][column] != '.') {
            return RowColoumn(board, nRow, nCol);
        } else {
            // Try placing numbers 1 to 9
            for (int i = 1; i <= 9; i++) {
                if (grid(board, row, column, i)) {
                    board[row][column] = (char) (i + '0'); // Place the number

                    // Recursively solve for the next cell
                    if (RowColoumn(board, nRow, nCol)) {
                        return true;
                    }

                    // Backtrack if placing the number didn't lead to a solution
                    board[row][column] = '.';
                }
            }
        }

        // If no number can be placed, return false
        return false;
    }

    public void sudoku(char[][] board) {
        if (RowColoumn(board, 0, 0)) {
            System.out.println("Solved Sudoku:");
            for (char[] row : board) {
                for (char cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Main method to test the Sudoku solver
    public static void main(String[] args) {
        Sudoku solver = new Sudoku();
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solver.sudoku(board);
    }
}

