package org.bsz.connect4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the human player's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        // Initialize players: human and computer
        Player human = new Player(playerName, 'Y', true);
        Player computer = new Player("Computer", 'R', false);

        // Create and start the game
        Game game = new Game(human, computer);
        game.start();
    }
}
