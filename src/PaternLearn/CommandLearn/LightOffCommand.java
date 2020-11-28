package PaternLearn.CommandLearn;

public class LightOffCommand implements Command {
    Light light;

    //В переменной light конструктору передается конкретный объект, которым будет управлять команда (допустим, освещение в гостиной).
    public LightOffCommand(Light ligth) {
        this.light = ligth;
    }

    @Override
    //При вызове execute получателем запроса будет объект light.
    public void execute() {
        light.off();
    }
}