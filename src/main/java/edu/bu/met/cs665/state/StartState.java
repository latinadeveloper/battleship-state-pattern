package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 */
public class StartState extends BlockState {
    public StartState(PositionBlock positionBlock) {
        super(positionBlock);
    }

    public void addShip() {
        this.positionBlock.setState(positionBlock.getShipNotFiredState());
    }
    public boolean canAddShip() { return true; }

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
