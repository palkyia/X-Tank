import java.awt.*;

/**
 * Builds and defines the various tank types. Extend the tank class and add it to this factory to create new types.
 */
enum TankType
{
    GIGA, GOLIATH, PHOTON, EXECUTIONER
}

class PhotonTank extends Tank
{
    PhotonTank(Point point){
        super(TankType.PHOTON, point);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
        this.armor = 3;
        this.isShooting = false;
        this.color = "tan";
        this.power = 2;
    }
}

class ExecutionerTank extends Tank
{
    ExecutionerTank(Point point) {
        super(TankType.EXECUTIONER, point);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
        this.armor = 1;
        this.isShooting = false;
        this.color = "purple";
        this.power = 3;
    }
}

class GigaTank extends Tank
{
    GigaTank(Point point){
        super(TankType.GIGA, point);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
        this.armor = 3;
        this.isShooting = false;
        this.color = "yellow";
        this.power = 1;
    }
}

class GoliathTank extends Tank{
    GoliathTank(Point point){
        super(TankType.GOLIATH, point);
        imgPath = "images/tank.png";
        type = "Tank";
        direction = "North";
        this.armor = 3;
        this.isShooting = false;
        this.color = "green";
        this.power = 1;
    }
}

class TankFactory
{
    public static Tank buildTank(TankType model, Point point)
    {
        Tank tank = null;
        switch (model) {
            case GIGA -> tank = new GigaTank(point);
            case GOLIATH -> tank = new GoliathTank(point);
            case PHOTON -> tank = new PhotonTank(point);
            case EXECUTIONER -> tank = new ExecutionerTank(point);
            default -> {
            }
        }
        return tank;
    }
}