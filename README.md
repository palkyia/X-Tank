# XTank - CSC 335 A3
#### Jacob Phan & Chris Fleming


### To Play

Run xTankServer.java to start the server on the host. Run xTankClient.java for each player. By default, the client 
attempts to connect to localhost. Replace localhost with your IP address in the main() function to connect to your server.

#### Controls:

Arrow keys  - movement

Space bar - shoot


### Game Rules & Tank Types
The default game mode plays with 4 different tank types having weapons and armor ranging from 1-3 power/armor.
Any amount of players can join, but only 4 unique tanks are implemented for the first 4 players. To create
a new tank type, extend the tank class and add it to the tankFactory, which can then be assigned to a player in 
Game.createTank(). To create a one-hit kill mode, change the starting armor of tanks to 1.


### Maps
To change maps, change the startConfig field in GridA.java. The game uses a 2D array of Strings to represent the map as a grid 
(Default 15 x 20). Use "W" at the corresponding coordinate position in the 2D array to add a wall ,  or "N" to leave open space. 