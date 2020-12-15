package PaternLearn.State;

public class SoldOutState implements State {

    GumballMachine gumballMachine;
    //Конструктору передается ссылка на объект автомата, которая просто сохраняется в переменной экземпляра.
    //Она используется для перевода автомата в другое состояние.
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can’t insert a quarter, the machine is sold out");
    }
    public void ejectQuarter() {
        System.out.println("You can’t eject, you haven’t inserted a quarter yet");
    }
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
