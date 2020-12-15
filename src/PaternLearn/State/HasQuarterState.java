package PaternLearn.State;

public class HasQuarterState implements State {

    GumballMachine gumballMachine;
    //Конструктору передается ссылка на объект автомата, которая просто сохраняется в переменной экземпляра.
    //Она используется для перевода автомата в другое состояние.
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can’t insert another quarter");
    }

    //Возвращ монету и меняем состояние.
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    //Когда покупатель дергает за рычаг, автомат переводится в состояние SoldState (вызовом метода setState() с объектом SoldState).
    //Для получения объекта SoldState используется метод getSoldState() (один из getметодов, определенных для всех состояний).
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
