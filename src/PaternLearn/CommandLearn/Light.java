package PaternLearn.CommandLearn;

public class Light {
    String nameRoom;

    public Light(String nameRoom)
    {
        this.nameRoom = nameRoom;
    }

    public void on() {
        System.out.println("В комнате " + this.nameRoom + " включилась лампочка!");
    }

    public void off() {
        System.out.println("В комнате " + this.nameRoom + " выключилась лампочка!");
    }
}
