import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Play is the command logic used to communicate with individual clients on a thread. Commands are received from the
 * client, then the game state is updated and sent back.
 */
public class Play implements Runnable{
    private Player player;
    private Game game;
    private Socket socket;

    public Play(Socket socket, Game game){
       this.socket = socket;
       this.game = game;

    }
    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            player = new Player(in, out);
            game.addPlayer(player);
            for (Player p: game.getPlayers()){
                p.getOutput().writeObject(new gameStateMessage(game.getGrid(), !p.getTank().isDead(), false, p.getTank().color));
                p.getOutput().flush();
                p.getOutput().reset();
            }
            System.out.println("Initial Grid");
            System.out.println(game.getGrid());
            processCommands();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to start stream or read stream for player");
        }
    }
    private void processCommands() throws IOException, ClassNotFoundException {
        while (true){
            try {
                clientMessage cmd = (clientMessage) player.getInput().readObject();
                System.out.println("Cmd received:");
                System.out.println(cmd.getCmd());
                switch (cmd.getCmd()){
                    case NORTH -> player.getTank().move(game.getGrid(), "North");
                    case EAST -> player.getTank().move(game.getGrid(), "East");
                    case SOUTH -> player.getTank().move(game.getGrid(), "South");
                    case WEST -> player.getTank().move(game.getGrid(), "West");
                    case SHOOT -> {
                        player.getTank().shoot(game.getGrid());
                        game.updateDeaths();
                        Player winner = game.checkWinner();
                        if (winner != null){
                            winner.getOutput().writeObject(new gameStateMessage(game.getGrid(), true, true, player.getTank().color));
                            return;
                        }
                    }
                }
                for (Player p: game.getPlayers()){
                    p.getOutput().writeObject(new gameStateMessage(game.getGrid(), !p.getTank().isDead(), false, p.getTank().color));
                    p.getOutput().flush();
                    p.getOutput().reset();
                }
            } catch (EOFException e){
                System.out.println("Connection closed, game over.");
               break;
            }

        }

    }
}
