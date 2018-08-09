package edu.bu.met.cs665;


import java.util.Scanner;

public class Main {

  // https://stackoverflow.com/questions/2979383/java-clear-the-console
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) throws java.io.IOException {
    int n = 5;
    int m = 5;
    int ships = 3;

    Board player1Board = new Board("Player 1", n, m);
    Board player2Board = new Board("Player 2", n, m);

    player1Board.addRandomFleet(ships);
    player1Board.startGame();

    player2Board.addRandomFleet(ships);
    player2Board.startGame();

    Scanner reading = new Scanner(System.in);
    // defines whos turn it is
    boolean turn = true;
    // for each turn it goes through this loop
    while(true) {
      System.out.print("Your Board: ");
      (turn ? player2Board : player1Board).printBoard(true);

      System.out.print("Opponents Board: ");
      Board opponentBoard = turn ? player1Board : player2Board;
      opponentBoard.printBoard(false);

      System.out.println("Row Letter: ");

      char letter = reading.next().charAt(0);
      if (letter < 'A' || letter > 'A' + m) {
        System.out.println("Invalid letter");
        continue;
      }

      System.out.println("Column Number: ");
      int number = reading.nextInt();
      if (number < 1 || number > n) {
        System.out.println("Invalid number");
        continue;
      }

      System.out.println("Firing Shot at " + letter + number);

      opponentBoard.fireShot(number - 1, letter - 'A');

      opponentBoard.printBoard(false);

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