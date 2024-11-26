package org.bsz.connect4;

import java.util.Random;

/**
 * Game class for Connect-4
 */
public class Game {
    private static final int WIN_COUNT = 4;  // 4 in a row to win
    private Board board;
    private Player humanPlayer;
    private Player computerPlayer;
    private Player currentPlayer;

    public Game(Player human, Player computer) {
        this.humanPlayer = human;
        this.computerPlayer = computer;
        this.board = new Board();  // Assuming a default 6x7 grid
        this.currentPlayer = humanPlayer;  // Human always starts
    }

    public void start() {
        boolean gameWon = false;

        while (!gameWon && !board.isFull()) {
            board.printBoard();
            if (currentPlayer.isHuman()) {
                int move = getHumanMove();
                board.makeMove(move, currentPlayer.getSymbol());
            } else {
                int move = getComputerMove();
                System.out.println("Computer chose column: " + (move + 1));
                board.makeMove(move, currentPlayer.getSymbol());
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                gameWon = true;
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
            }

            // Switch player
            currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
        }
    }

    // Get the human player's move from input
    private int getHumanMove() {
        int col;
        do {
            System.out.println("Your turn (" + humanPlayer.getSymbol() + "). Choose a column (1 to " + board.getCols() + "): ");
            col = humanPlayer.getMove() - 1;  // Assuming 1-based input, adjust to 0-based index
            if (!board.isValidMove(col)) {
                System.out.println("Invalid move. Try again.");
            }
        } while (!board.isValidMove(col));
        return col;
    }

    // Get a random valid move for the computer
    private int getComputerMove() {
        Random random = new Random();
        int col;
        do {
            col = random.nextInt(board.getCols());
        } while (!board.isValidMove(col));
        return col;
    }
}
