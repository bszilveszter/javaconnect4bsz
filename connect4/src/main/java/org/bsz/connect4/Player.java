package org.bsz.connect4;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private boolean isHuman;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, char symbol, boolean isHuman) {
        this.name = name;
        this.symbol = symbol;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getMove() {
        if (isHuman) {
            System.out.print("Enter column number: ");
            return scanner.nextInt();
        }
        return -1;  // Placeholder, not used for computer player
    }
}
