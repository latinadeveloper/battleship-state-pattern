package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class ShipHitState extends BlockState {
    public ShipHitState(PositionBlock positionBlock) {
        super(positionBlock);
    }

    public void addShip() {
        System.out.println("ShipHitState: A ship is already here");
    }

    public void startGame() {
    }

    public void fireShot() {
        System.out.println("Ship already hit");
    }

    public String getMarking(boolean owner) {
        return "X";
    }
}
