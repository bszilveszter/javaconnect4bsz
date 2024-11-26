package org.bsz.connect4;

public class Board {
    private static final char EMPTY = '.';
    private static final int WIN_COUNT = 4;  // 4 in a row to win
    private final int rows = 6;  // Number of rows
    private final int cols = 7;  // Number of columns
    private char[][] grid;

    public Board() {
        grid = new char[rows][cols];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isValidMove(int col) {
        return col >= 0 && col < cols && grid[0][col] == EMPTY;
    }

    public void makeMove(int col, char playerSymbol) {
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][col] == EMPTY) {
                grid[i][col] = playerSymbol;
                break;
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char playerSymbol) {
        return checkVertical(playerSymbol) || checkHorizontal(playerSymbol) || checkDiagonal(playerSymbol);
    }

    private boolean checkVertical(char playerSymbol) {
        for (int col = 0; col < cols; col++) {
            int count = 0;
            for (int row = 0; row < rows; row++) {
                count = (grid[row][col] == playerSymbol) ? count + 1 : 0;
                if (count == WIN_COUNT) return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal(char playerSymbol) {
        for (int row = 0; row < rows; row++) {
            int count = 0;
            for (int col = 0; col < cols; col++) {
                count = (grid[row][col] == playerSymbol) ? count + 1 : 0;
                if (count == WIN_COUNT) return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(char playerSymbol) {
        // Check diagonals from bottom-left to top-right
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (grid[row][col] == playerSymbol && grid[row - 1][col + 1] == playerSymbol &&
                        grid[row - 2][col + 2] == playerSymbol && grid[row - 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }
        // Check diagonals from top-left to bottom-right
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (grid[row][col] == playerSymbol && grid[row + 1][col + 1] == playerSymbol &&
                        grid[row + 2][col + 2] == playerSymbol && grid[row + 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getCols() {
        return cols;
    }
}
