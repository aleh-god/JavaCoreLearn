package PaternLearn.InterfaceCapsule;

abstract class Human {
    void display() {
    }
}

class Man extends Human {
    Work workBehavior;

    void display() {
    }

    public String playWork() {
        workBehavior = new WorkBehavior();
        return workBehavior.startWork();
    }
}

class Woman extends Human {
    Relax relaxBehavior;
    public void playRelax() {
        relaxBehavior = new RelaxBehavior();
        relaxBehavior.relax();
    }
}