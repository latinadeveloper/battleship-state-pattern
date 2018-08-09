package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class ShipNotFiredState extends BlockState {
    private PositionBlock positionBlock;

    public ShipNotFiredState(PositionBlock positionBlock) {
        this.positionBlock = positionBlock;
    }

    public void addShip() {
        System.out.println("ShipNotFiredState: A ship is already here");
    }

    public void startGame() {
    }

    public void fireShot() {
        this.positionBlock.getShip().hit();
        if (this.positionBlock.getShip().sunk()) {
            System.out.println("!!! You sunk my " + this.positionBlock.getShip().getName());
        } else {
            System.out.println("!!! Hit ");
        }
        this.positionBlock.setState(positionBlock.getShipHitState());
    }

    public String getMarking(boolean owner) {
        return owner ? positionBlock.getShip().getNumber().toString() : "-";
    }
}
