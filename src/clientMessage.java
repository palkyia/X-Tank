import java.io.Serializable;

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
