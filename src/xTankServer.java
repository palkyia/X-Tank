import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class xTankServer {
    public static void main(String[] args) {
        try (var listener = new ServerSocket(58901)){
            System.out.println("XTank server started...");
            Game game = new Game();
            var pool = Executors.newFixedThreadPool(10);
            while (true){
                pool.execute(new Play(listener.accept(), game));

            }
//                System.out.println(socket);
//                Scanner in = new Scanner(socket.getInputStream());
//                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                if (in.hasNextLine()){
//                    System.out.println(in.nextLine());
//                }



        } catch (IOException e) {
            throw new RuntimeException("Server failed to open a socket.");
        }
    }
    public enum commands{
        NORTH, EAST, SOUTH, WEST, SHOOT, DIE, WINNER
    }
}

