package PaternLearn.CommandLearn;

public class GarageDoor {

    public GarageDoor() {
        System.out.println("Ворота установлены.");
    }

    public void up() {
        System.out.println("Ворота открываются!");
    }

    public void down() {
        System.out.println("Ворота зкрываются!");
    }

    public void stop() {
        System.out.println("Ворота остановились!");
    }

    public void lightOn() {
        System.out.println("Свет в гараже включен!");
    }

    public void lightOff() {
        System.out.println("Свет в гараже выключен");
    }
}