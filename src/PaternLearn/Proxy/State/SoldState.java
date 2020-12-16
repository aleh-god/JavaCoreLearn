package PaternLearn.Proxy.State;

public class SoldState implements State {

    GumballMachine gumballMachine;
    //Конструктору передается ссылка на объект автомата, которая просто сохраняется в переменной экземпляра.
    //Она используется для перевода автомата в другое состояние.
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("Please wait, we’re already giving you a gumball");
    }
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }
    public void turnCrank() {
        System.out.println("Turning twice doesn’t get you another gumball!");
    }

    //Находимся в состоянии SoldState, т. е. покупка оплачена. Сначала приказываем автомату выдать шарик.
    //Затем проверяем количество шариков, и в зависимости от результата переходим в состояние NoQuarterState или SoldOutState.
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
