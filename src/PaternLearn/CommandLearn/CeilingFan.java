package PaternLearn.CommandLearn;

public class CeilingFan {
    String nameRoom;
    //Скорость вентилятора
    int speed;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    int lastSpeed;

    public CeilingFan(String nameRoom)
    {
        this.nameRoom = nameRoom;
        this.speed = OFF;
        this.lastSpeed = LOW;
    }

    public int getSpeed() {
        return speed;
    }

    public void low() {
        speed = LOW;
        System.out.println("В комнате " + nameRoom + ". Скорость = " + speed);

    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("В комнате " + nameRoom + ". Скорость = " + speed);
    }

    public void high() {
        speed = HIGH;
        System.out.println("В комнате " + nameRoom + ". Скорость = " + speed);
    }

    public void off() {
        lastSpeed = speed;
        speed = OFF;
        System.out.println("В комнате " + nameRoom + " выключилась вентиляция!");
    }

    public void on() {
        speed = lastSpeed;
        System.out.println("В комнате " + nameRoom + " включилась вентиляция! Скорость = " + speed);
    }
}