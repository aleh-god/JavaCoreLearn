package PaternLearn.CommandLearn;

public class CeilingFanHighCommand implements Command{
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.lastSpeed = ceilingFan.getSpeed();
        if (ceilingFan.getSpeed() == CeilingFan.OFF) {
            System.out.println("Вентилятор включен. " + CeilingFan.LOW);
            ceilingFan.low();
        } else if (ceilingFan.getSpeed() == CeilingFan.LOW) {
            System.out.println("Скорость вентилятора увеличена до = " + CeilingFan.MEDIUM);
            ceilingFan.medium();
        } else if (ceilingFan.getSpeed() == CeilingFan.MEDIUM) {
            System.out.println("Скорость вентилятора увеличена до = " + CeilingFan.HIGH);
            ceilingFan.high();
        }
    }

    @Override
    public void undo() {
        prevSpeed = ceilingFan.lastSpeed;
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
            System.out.println("Скорость вентилятора возвращена на " + ceilingFan.getSpeed());
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
            System.out.println("Скорость вентилятора возвращена на " + ceilingFan.getSpeed());
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
            System.out.println("Скорость вентилятора возвращена на " + ceilingFan.getSpeed());
        }
    }
}