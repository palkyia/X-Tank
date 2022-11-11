import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class xTankServer {
    public static void main(String[] args) {
        Game game = null;
        try (var listener = new ServerSocket(58901)) {
            System.out.println("XTank server started...");
            game = new Game();
            var pool = Executors.newFixedThreadPool(10);
            while (true) {
                pool.execute(new Play(listener.accept(), game));

            }

        } catch (IOException e) {
            throw new RuntimeException("Server failed to open a socket.");
        } finally {
            System.out.println("Player " + game.checkWinner().getTank().color + " wins!");
        }

    }
    public enum commands{
        NORTH, EAST, SOUTH, WEST, SHOOT
    }
}

