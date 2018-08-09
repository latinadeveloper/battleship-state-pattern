package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class WaterNotFiredState extends BlockState {
    private PositionBlock positionBlock;

    public WaterNotFiredState(PositionBlock positionBlock) {
        this.positionBlock = positionBlock;
    }

    public void addShip() {
        System.out.println("WaterNotFiredState: A ship is already here");
    }

    public void startGame() {
    }

    public void fireShot() {
        System.out.println("!!! Miss ");
        this.positionBlock.setState(positionBlock.getWaterFiredState());
    }

    public String getMarking(boolean owner) {
        return "-";
    }
}
