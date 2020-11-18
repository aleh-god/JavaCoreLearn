package PaternLearn.InterfaceCapsule;

abstract class Human {
    void display() {
    }
}

class Man extends Human {
    WorkBehavior workBehavior;

    public String playWork() {
        workBehavior = new WorkBehavior();
        return workBehavior.startWork();
    }
}

class Woman extends Human {
    RelaxBehavior relaxBehavior;
    public void playRelax() {
        relaxBehavior = new RelaxBehavior();
        relaxBehavior.relax();
    }
}