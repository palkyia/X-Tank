import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

/**
 * The client for XTank, starts the GUI for player interaction and opens a connection to the XTankServer, handling the
 * received messages.
 */
public class xTankClient {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private static xTankGUI map;
    private static JLabel messageLabel;
    private static JFrame frame;

 public static void main(String[] args) throws IOException, ClassNotFoundException {
        //default address is localhost. Change to the IP address of your server to connect.
        xTankClient client = new xTankClient("127.0.0.1");
        initFrame(client.getOutput());
        client.processCommands();
    }

    public xTankClient(String address) throws IOException {
        socket = new Socket(address, 58901);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());


    }

    private void processCommands() throws IOException, ClassNotFoundException {
        while (true){
            try {
                gameStateMessage msg = (gameStateMessage) input.readObject();
                if (!msg.isAlive){
                    JOptionPane.showMessageDialog(frame, "YOU DIED...");
                    socket.close();
                    frame.dispose();
                    return;
                } else if (msg.isWinner) {
                    JOptionPane.showMessageDialog(frame, "#1 Victory Royale");
                    socket.close();
                    frame.dispose();
                    return;
                } else {
                    System.out.println(msg.getGrid());
                    map.setGrid(msg.getGrid());
                    messageLabel.setText("You are Player: " + msg.playerColor);
                }

            } catch (EOFException e){
                System.out.println("client stream closed...");
                break;
            }


        }

    }

   

    private static void initFrame(ObjectOutputStream output){
        frame = new JFrame("Xtank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messageLabel = new JLabel("Welcome to XTank!",SwingConstants.CENTER);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);
        map = new xTankGUI(output);
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
