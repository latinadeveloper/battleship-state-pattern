package edu.bu.met.cs665.state;
import edu.bu.met.cs665.PositionBlock;

/**
 *
 * @author isis
 * parent of all of the states
 * first three are actions the other is information
 */


public abstract class BlockState {
   protected PositionBlock positionBlock;

   protected BlockState(PositionBlock positionBlock) {
      this.positionBlock = positionBlock;
   }

   abstract public void addShip();
   // Board no longer needs any knowledge of states with this method to determine if a ship will overlap with another ship
   public boolean canAddShip() { return false; }
   abstract public void startGame();
   abstract public void fireShot();
   abstract public String getMarking(boolean owner);
}
