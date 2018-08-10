package edu.bu.met.cs665;

import java.util.ArrayList;

public class Board {
    String player;
    int n;
    int m;
    PositionBlock[][] positionBlocks;
    ArrayList<Ship> ships;

    public Board(String player, int n, int m) {
        this.player = player;
        this.n = n;
        this.m = m;
        positionBlocks = new PositionBlock[n][m];
        // create object for each position block in 2 dimensional array
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                positionBlocks[row][column] = new PositionBlock();
            }
        }
        // keeps list of ships
        ships = new ArrayList<Ship>();
    }

    public String getPlayer() {
        return player;
    }

    public void printBoard(boolean owner) {
        System.out.println(player);

        System.out.print("     ");
        for (int column = 0; column < m; column++) {
            System.out.print("| " + (char)('A' + column) + " ");
        }
        System.out.println("|");

        for (int row = 0; row < n; row++) {
            System.out.println("  --------------------------------------------");

            // https://www.homeandlearn.co.uk/java/java_formatted_strings.html
            System.out.printf("  %2d ", row + 1);
            for (int column = 0; column < m; column++) {

                System.out.print("| " + positionBlocks[row][column].getMarking(owner) + " ");
            }
            System.out.println("|");
        }
        System.out.println("  --------------------------------------------");
        if (owner) {
            System.out.println("  Ships:");
        } else {
            System.out.println("  Ships Sunk:");
        }

            // gives summary of the ships
        for (Ship ship : ships) {
            if (owner) {
                System.out.print("    " + ship.getNumber() + " - " + ship.getName());
                System.out.println(ship.sunk() ? " (SUNK)" : "");
            } else if (ship.sunk()) {
                System.out.println("    " + ship.getName());
            }
        }
        System.out.println();
    }
    
    // add ship to board starting at n,m positions
    public void addShip(Ship ship, int n, int m, boolean direction) {
        ships.add(ship);
        for(int l = 0; l < ship.getSize(); l++) {
            positionBlocks[n][m].addShip(ship);
            if (direction) {
                n++;
            } else {
                m++;
            }
        }
    }

    // detrmines if the ships will overlap over one another, if so will try 
    // random again
    public boolean canAddShip(Ship ship, int n, int m, boolean direction) {
        for(int l = 0; l < ship.getSize(); l++) {
            if (!(positionBlocks[n][m].canAddShip())) {
                return false;
            }
            if (direction) {
                n++;
            } else {
                m++;
            }
        }
        return true;
    }

    // adding shio randomly
    public void addShipToRandomLocation(Ship ship) {
        while (true) {
            boolean direction = Math.random() > 0.5;
            int n = (int)((this.n - (direction ? ship.getSize() : 0)) * Math.random());
            int m = (int)((this.m - (direction ? 0 : ship.getSize())) * Math.random());
            if (canAddShip(ship, n, m, direction)) {
                addShip(ship, n, m, direction);
                return;
            }
        }
    }

    public void addRandomFleet(int size) {
        Ship ships[] = {
                new Ship("Destroyer", 5, 2),
                new Ship("Submarine", 4, 3),
                new Ship("Cruiser", 3, 3),
                new Ship("Battleship", 2, 4),
                new Ship("Carrier", 1, 5)
        };

        for (int i = 0; i < Math.min(size, 5); i++) {
            addShipToRandomLocation(ships[i]);
        }
    }

    public void startGame() {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                positionBlocks[row][column].startGame();
            }
        }
    }

    public void fireShot(int n, int m) {
        positionBlocks[n][m].fireShot();
    }

    public boolean won() {
        for (Ship ship : ships) {
            if (!ship.sunk()) {
                return false;
            }
        }
        return true;
    }
}
