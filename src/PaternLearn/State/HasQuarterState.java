package PaternLearn.State;

import java.util.Random;

//Толбко в этом состоянии дергаем за рычаг, значит режим удачи вводим здесь.
public class HasQuarterState implements State {
    //Добавляем генератор случайных чисел для режима Удачи.
    Random randomWinner = new Random(System.currentTimeMillis());

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
        //Для получения объекта getNoQuarterState используется метод setState() (один из get-методов, определенных для всех состояний).
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    //Когда покупатель дергает за рычаг, автомат переводится в состояние SoldState (вызовом метода setState() с объектом SoldState).
    public void turnCrank() {
        System.out.println("You turned...");
                                        //с 10%-й вероятностью выигрыша
        int winner = randomWinner.nextInt(10);
        //Если покупателю повезло, и в автомате остался второй шарик, переходим в состояние WinnerState;
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            //в противном случае переходим в состояние SoldState (как делалось ранее).
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
