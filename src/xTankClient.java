import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class xTankClient {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public xTankClient(String address) throws IOException, ClassNotFoundException {
        socket = new Socket(address, 58901);

        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        //testing
        output.writeObject(new clientMessage(xTankServer.commands.DIE));
        output.writeObject(new clientMessage(xTankServer.commands.EAST));

        gameStateMessage msg = (gameStateMessage) input.readObject();
        System.out.println(msg.grid);
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        xTankClient client = new xTankClient("127.0.0.1");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initFrame();
            }
        });
    }

    private static void initFrame(){
        JFrame frame = new JFrame("Xtank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMap map = new gameMap();
        map.setGrid(new GridA());
        frame.add(map);
        frame.setResizable(false);
        frame.addKeyListener(map);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
