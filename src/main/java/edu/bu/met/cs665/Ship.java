package edu.bu.met.cs665;

public class Ship {
    private String name;
    private Integer number;
    private int size;
    private int hits;

    public Ship(String name, Integer number, int size) {
        this.name = name;
        this.number = number;
        this.size = size;
        this.hits = 0;
    }

    public void hit() {
        hits++;
    }

    public boolean sunk() {
        return hits >= size;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public int getHits() {
        return hits;
    }
}