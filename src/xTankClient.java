import javax.swing.*;

public class xTankClient {

    public static void main(String[] args) {
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
        frame.add(map);
        frame.setResizable(false);
        frame.addKeyListener(map);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
