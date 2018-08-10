package edu.bu.met.cs665;

public class Main {



  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) throws java.io.IOException {
    int n = 5;
    int m = 5;
    int ships = 3;

    Game game = new Game(n, m, ships);

    game.play();
  }

}