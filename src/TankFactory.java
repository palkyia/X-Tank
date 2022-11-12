import java.awt.*;
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
        this.armor = 3;
        this.isShooting = false;
        this.color = "purple";
        this.power = 1;
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
        switch (model)
        {
            case GIGA:
                tank = new GigaTank(point);
                break;
            case GOLIATH:
                tank = new GoliathTank(point);
                break;
            case PHOTON:
                tank = new PhotonTank(point);
                break;
            case EXECUTIONER:
                tank = new ExecutionerTank(point);
                break;
            default:
                break;

        }
        return tank;
    }
}