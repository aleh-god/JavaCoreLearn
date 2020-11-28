package PaternLearn.CommandLearn;

public class CeilingFan {
    String nameRoom;

    public CeilingFan(String nameRoom)
    {
        this.nameRoom = nameRoom;
    }

    public void on() {
        System.out.println("В комнате " + this.nameRoom + " включилась вентиляция!");
    }

    public void off() {
        System.out.println("В комнате " + this.nameRoom + " выключилась вентиляция!");
    }
}