#Refactoring 

##3 refactoring issues:
Composing Methods. 
Improving Readability
Placed procedural code in main into a class Game and extracted into multiple 
methods with clear purpose to improve readability.  
The game class has the size of the board common to the 2 boards and the number of ships. 
 This has a play method that calls an extracted method playAgainstBoard to handle the each players turn.

Moving features between two objects.Hiding Delegate. 
The existing board class has a method to determine if a ship could be added 
in a given position used to ensure randomly generated ship locations would not overlap.  
This method checked if the state of the position block as StartState.  
This was changed so the PositionBlock has a canAddShip() method returning 
boolean that delegates to the State.  This allows removing any reference the the 
states on the Board object reducing coupling.

Dealing with Generalization
The positionBlock instance variable repeated on each state class was pulled up 
to the abstract parent BlockState.

The Game class was changed to be a singleton.




# BattleShip

Application Description:
Basic implementation for the game battle ship. The state pattern is used in this application. 
Here the main context is the Position Block. The Position Block will end up having several 
states known as concrete states. All of the states are being passed through the Block State interface. 
The behavior of the position block will be altered depending on what state is picked.
This brings flexibility because new states can be added by just adding a class.
Any number of ships can be added as long as they fit on the board. 


#Implementation Details:
This is a console game that will be played only two players.
The game board will be initialized as a 5 x 5 board. 
The parameters being passed in can be changed so the board comes up at different dimensions. 
The game by default uses three ships, which can be increased up to 5 total ships 
by changing the number of the variable name ships.
The player shoots the shit by entering the position on the board by column letter 
and row number. The letter must be entered as capital letter. 
The board will display where the ships are according to the legend at the bottom. 
The legend has numbers with the name, the number will be displayed in the position block. 

When the shot is fired, it will display a *, - or X. 
* is a miss
- is nothing fired yet
X is a hit





