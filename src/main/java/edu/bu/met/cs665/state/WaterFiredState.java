package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class WaterFiredState extends BlockState {
    private PositionBlock positionBlock;

    public WaterFiredState(PositionBlock positionBlock) {
        this.positionBlock = positionBlock;
    }

    public void addShip() {
        System.out.println("WaterFiredState: A ship is already here");
    }

    public void startGame() {
    }

    public void fireShot() {
        System.out.println("Position already hit");
    }

    public String getMarking(boolean owner) {
        return "*";
    }
}
