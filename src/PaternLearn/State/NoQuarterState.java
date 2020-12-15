package PaternLearn.State;

public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    //Конструктору передается ссылка на объект автомата, которая просто сохраняется в переменной экземпляра.
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    //Если в автомат брошена монетка, вывести сообщение и перейти в состояние HasQuarterState.
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    public void ejectQuarter() {
        System.out.println("You haven’t inserted a quarter");
    }
    public void turnCrank() {
        System.out.println("You turned, but there’s no quarter");
    }
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
