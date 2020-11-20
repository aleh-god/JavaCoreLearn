package PaternLearn.InterfaceCapsule;

public class Robot {
    Work workBehavior;
    String nameRobot;

    public Robot(String nameRobot) {
        this.nameRobot = nameRobot;

        // Привязываем необходимое заменяемое поведение для класса.
        workBehavior = new WorkBehavior();
    }

    public void display() {
        System.out.println("I am a robot!");
    }

    public String playWork() {
        // Вызываем поведение класса через универсальную комманду. Делегируем поведение.
        return workBehavior.startWork();
    }

    public void setWorkBehavior(Work workBehavior) {
        this.workBehavior = workBehavior;
    }
}
