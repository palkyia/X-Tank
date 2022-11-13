import java.io.Serializable;

/**
 * The message object sent through the stream from the client to the server, telling the server how the player
 * is attempting to move.
 */
public class clientMessage implements Serializable {
    private xTankServer.commands cmd;
    public clientMessage(xTankServer.commands command){
        cmd = command;
    }

    public xTankServer.commands getCmd() {
        return cmd;
    }

    public void setCmd(xTankServer.commands cmd) {
        this.cmd = cmd;
    }
}
