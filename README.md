# Sudoku Solver

A Java-based Sudoku solver that uses backtracking to solve Sudoku puzzles. This program validates input, solves the puzzle, and prints the solution if one exists.

## Features
- **Backtracking Algorithm**: Efficiently solves Sudoku puzzles by recursively filling numbers while adhering to Sudoku rules.
- **Validation**: Ensures numbers in rows, columns, and 3x3 subgrids are valid before placement.
- **User-Friendly Output**: Displays the solved Sudoku grid or indicates if no solution exists.

## How It Works
1. **Grid Validation**: The program checks if a number can be placed in a cell by ensuring no conflicts in the row, column, and 3x3 subgrid.
2. **Recursive Solving**: Using backtracking, the program tries placing numbers from 1 to 9 in empty cells and recursively solves the puzzle.
3. **Backtracking**: If placing a number doesn't lead to a solution, the program removes it and tries the next number.

## Usage
### Input
The input Sudoku puzzle should be represented as a 2D `char` array where:
- Digits (`'1'` to `'9'`) represent filled cells.
- A dot (`'.'`) represents an empty cell.

### Output
The program will either:
- Print the solved Sudoku grid.
- Indicate that no solution exists.

## Code Example
### Sample Input
```java
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
