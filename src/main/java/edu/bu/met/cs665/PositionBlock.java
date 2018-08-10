package edu.bu.met.cs665;
import edu.bu.met.cs665.state.*;


public class PositionBlock {
    StartState startState;
    WaterNotFiredState waterNotFiredState;
    WaterFiredState waterFiredState;
    ShipNotFiredState shipNotFiredState;
    ShipHitState shipHitState;

    BlockState state;
    Ship ship;

    public PositionBlock() {
        this.startState = new StartState(this);
        this.waterNotFiredState = new WaterNotFiredState(this);
        this.waterFiredState = new WaterFiredState(this);
        this.shipNotFiredState = new ShipNotFiredState(this);
        this.shipHitState = new ShipHitState(this);
        
        this.state = startState;
    }

    // setup ship on this block and transition block from StartState to ShipNotFiredState
    public void addShip(Ship ship) {
        this.ship = ship;
        state.addShip();
    }

    public boolean canAddShip() {
        return state.canAddShip();
    }

    public void startGame() {
        state.startGame();
    }

    public void fireShot() {
        state.fireShot();
    }
    
    public BlockState getStartState() {
        return this.startState;
    }
    public BlockState getWaterNotFiredState() {
        return this.waterNotFiredState;
    }
    public BlockState getWaterFiredState() {
        return this.waterFiredState;
    }
    public BlockState getShipNotFiredState() {
        return this.shipNotFiredState;
    }
    public BlockState getShipHitState() {
        return this.shipHitState;
    }

    public String getMarking(boolean owner) { return state.getMarking(owner); }

    public BlockState getState() {
        return state;
    }
    public void setState(BlockState state) {
        this.state = state;
    }

    public Ship getShip() {
        return ship;
    }
}
