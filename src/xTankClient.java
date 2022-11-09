import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class xTankClient {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private static gameMap map;

    public xTankClient(String address) throws IOException, ClassNotFoundException {
        socket = new Socket(address, 58901);

        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        //testing
        gameStateMessage msg1 = (gameStateMessage) input.readObject();
        System.out.println(msg1.getGrid());
        output.writeObject(new clientMessage(xTankServer.commands.EAST));


        gameStateMessage msg = (gameStateMessage) input.readObject();
        System.out.println(msg.grid);

        output.writeObject(new clientMessage(xTankServer.commands.EAST));

        gameStateMessage msg3 = (gameStateMessage) input.readObject();
        System.out.println(msg3.grid);


    }

    private void processCommands() throws IOException, ClassNotFoundException {
        System.out.println("we are in the looop!");
        while (true){
            try {
                gameStateMessage msg = (gameStateMessage) input.readObject();
                System.out.println(map.getGrid());
                map.setGrid(msg.getGrid());
            } catch (EOFException e){
                System.out.println("client stream closed...");
                break;
            }


        }

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        xTankClient client = new xTankClient("127.0.0.1");
        initFrame(client.getOutput());
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                initFrame(client.getOutput());
//
//            }
//        });

        client.processCommands();



    }

    private static void initFrame(ObjectOutputStream output){
        JFrame frame = new JFrame("Xtank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        map = new gameMap(output);
        map.setGrid(new GridA());
        frame.add(map);
        frame.setResizable(false);
        frame.addKeyListener(map);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ObjectOutputStream getOutput() {
        return output;
    }
}
