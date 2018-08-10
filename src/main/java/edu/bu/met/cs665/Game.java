package edu.bu.met.cs665;

import java.util.Scanner;

// Game class introduced to conver some procedures in Main to an Object with extracting methods from larger proceedure

public class Game {
    Board player1Board;
    Board player2Board;

    int n;
    int m;

    public Game(int n, int m, int ships) {
        this.n = n;
        this.m = m;

        player1Board = new Board("Player 1", n, m);
        player2Board = new Board("Player 2", n, m);

        player1Board.addRandomFleet(ships);
        player1Board.startGame();

        player2Board.addRandomFleet(ships);
        player2Board.startGame();
    }

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int askLetter(int max) {
        Scanner reading = new Scanner(System.in);

        while (true) {
            System.out.print("Row Letter: ");
            char letter = reading.next().charAt(0);
            if (letter >= 'A' && letter < 'A' + max) {
                return letter - 'A';
            }
            System.out.println("Invalid letter");
        }
    }

    public int askNumber(int max) {
        Scanner reading = new Scanner(System.in);

        while (true) {
            System.out.print("Column Number: ");
            int number = reading.nextInt();
            if (number > 0 && number <= max) {
                return number - 1;
            }
            System.out.println("Invalid number");
        }
    }

    public void playAgainstBoard(Board opponentBoard) {
        opponentBoard.printBoard(false);

        int row = askLetter(m);
        int column = askNumber(n);
        opponentBoard.fireShot(row, column);

        opponentBoard.printBoard(false);
    }

    public void play() throws java.io.IOException {
        // defines whos turn it is
        boolean turn = true;
        // for each turn it goes through this loop
        while(true) {
            System.out.print("Your Board: ");
            (turn ? player2Board : player1Board).printBoard(true);

            System.out.print("Opponents Board: ");
            playAgainstBoard(turn ? player1Board : player2Board);

            if (player1Board.won() || player2Board.won()) {
                break;
            }

            System.out.println("Press any key for next player.");
            System.in.read();
            clearScreen();

            turn = !turn;
        }

        System.out.println(player1Board.won() ? player1Board.getPlayer() : player2Board.getPlayer() + " Won !!!");
    }
}
