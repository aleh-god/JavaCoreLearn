package PaternLearn.InterfaceCapsule;

abstract class Human {
    //Привязываем к абстр классу пустые ссылки на интерфейсы
    Work workBehavior;
    Relax relaxBehavior;

    public void setWorkBehavior(Work workBehavior) {
        this.workBehavior = workBehavior;
    }

    public void setRelaxBehavior(Relax relaxBehavior) {
        this.relaxBehavior = relaxBehavior;
    }

    public void display() {
    }
}

class Man extends Human {
    String nameMan;

    public Man(String nameMan) {
        this.nameMan = nameMan;

        // Привязываем необходимое заменяемое поведение для класса.
        workBehavior = new WorkBehavior();
    }

    @Override
    public void display() {
        System.out.println("I am a man!");
    }

    public String playWork() {
        // Вызываем поведение класса через универсальную комманду. Делегируем поведение.
        return workBehavior.startWork();
    }
}

class Woman extends Human {
    String womanName;

    public Woman(String womanName) {
        this.womanName = womanName;

        // Привязываем необходимое заменяемое поведение для класса.
        relaxBehavior = new RelaxBehavior();
    }

    @Override
    public void display() {
        System.out.println("I am a woman!");
    }

    public void playRelax() {
        // Вызываем поведение класса через универсальную комманду. Делегируем поведение.
        relaxBehavior.relax();
    }
}