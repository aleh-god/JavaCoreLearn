package PaternLearn.InterfaceCapsule;

abstract class Human {
    void display() {
    }


}

class Man extends Human {
    public String nameMan;
    Work workBehavior;

    public Man(String nameMan)  {
        this.nameMan = nameMan;
        workBehavior = new WorkBehavior();
    }

    public void setWorkBehavior(Work workBehavior) {
        this.workBehavior = workBehavior;
    }

    void display() {
    }

    public String playWork() {
        return workBehavior.startWork();
    }
}

class Woman extends Human {
    public String womanName;
    Relax relaxBehavior;

    public Woman(String womanName){
        relaxBehavior = new RelaxBehavior();
        this.womanName = womanName;
    }



    public void playRelax() {
        relaxBehavior.relax();
    }
}