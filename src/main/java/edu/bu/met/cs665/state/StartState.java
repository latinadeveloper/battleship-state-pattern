package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class StartState extends BlockState {
    private PositionBlock positionBlock;

    public StartState(PositionBlock positionBlock) {
        this.positionBlock = positionBlock;
    }

    public void addShip() {
        this.positionBlock.setState(positionBlock.getShipNotFiredState());
    }

    public void startGame() {
        this.positionBlock.setState(positionBlock.getWaterNotFiredState());
    }

    public void fireShot() {
        System.out.println("StartState: Can't fire a shot until the game starts");
    }

    public String getMarking(boolean owner) {
        return "?";
    }
}
