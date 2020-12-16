package PaternLearn.Proxy.State;

public class GumballMachine {

    String location;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State winnerState; //Добавляем новый режим
    State soldState;
    State state = soldOutState;
    int count = 0;

    //Конструктор получает исходное количество шариков и сохраняет его в переменной.  Он также создает экземпляры State для всех состояний.
    public GumballMachine(String location, int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;

        //Если количество шариков >0, устанавливается состояние NoQuarterState;
        //в противном случае начинаем в состоянии SoldOutState.
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    //Действия реализуются ОЧЕНЬ ПРОСТО: операция делегируется объекту текущего состояния.
    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    //Для метода dispense() в классе GumballMachine метод действия не нужен, потому что это внутреннее действие; пользователь не может напрямую
    //потребовать, чтобы автомат выдал шарик. Однако метод dispense() для объекта State вызывается из метода turnCrank().
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    //Этот метод позволяет другим объектам (в частности, нашим объектам State) перевести автомат в другое состояние.
    void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return this.state;
    }

    //Вспомогательный метод releaseBall() отпускает шарик и уменьшает значение переменной count.
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    // Другие методы, включая get-методы для всех состояний...
    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    //Количество шариков
    public int getCount() {
        return this.count;
    }

    public String getLocation() {
        return location;
    }

    //Загрузка автомата
    public void refill(int numberGumballs) {
        //Если количество шариков >0, устанавливается состояние NoQuarterState;
        //в противном случае начинаем в состоянии SoldOutState.
        if (numberGumballs > 0) {
            this.count = this.count + numberGumballs;
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }
}
