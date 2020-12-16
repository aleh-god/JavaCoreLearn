package PaternLearn.Proxy.State;

public class GumballMonitor {

    GumballMachine machine;

    //Конструктор получает объект автомата и сохраняет его в переменной экземпляра machine.
    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    //Метод формирующий отчет.
    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }
}
