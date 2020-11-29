package PaternLearn.CommandLearn;

public class CeilingFanLowCommand implements Command{
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.lastSpeed = ceilingFan.getSpeed();
        if (ceilingFan.getSpeed() == CeilingFan.HIGH) {
            System.out.println("Скорость вентилятора уменьшена до = " + CeilingFan.MEDIUM);
            ceilingFan.medium();
        } else if (ceilingFan.getSpeed() == CeilingFan.MEDIUM) {
            System.out.println("Скорость вентилятора уменьшена до = " + CeilingFan.LOW);
            ceilingFan.low();
        } else if (ceilingFan.getSpeed() == CeilingFan.LOW) {
            System.out.println("Вентилятор выключен.\n");
            ceilingFan.off();
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
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
            System.out.println("Вентилятор выключен.\n");
        }
    }
}