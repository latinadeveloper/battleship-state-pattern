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





