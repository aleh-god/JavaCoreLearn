package PaternLearn.CommandLearn;

public class GarageDoorOpenCommand implements Command {
    // Объект которым будем управлять
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
        garageDoor.lightOn();
    }
}