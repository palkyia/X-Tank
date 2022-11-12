# XTank - CSC 335 A3
#### Jacob Phan & Chris Fleming


### To Play

Run xTankServer.java to start the server on the host. Run xTankClient.java for each player. By default, the client 
attempts to connect to localhost. Replace localhost with your IP address in the main() function to connect to your server.

#### Controls:

Arrow keys  - movement

Space bar - shoot

### Maps
To change maps, change the startConfig field in GridA.java. The game uses a 2D array of Strings to represent the map as a grid 
(Default 15 x 20). Use "W" at the corresponding coordinate position in the 2D array to add a wall ,  or "N" to leave open space. 