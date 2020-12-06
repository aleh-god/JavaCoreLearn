package PaternLearn.AdapterLearn;

                        //интерфейс того типа, на который рассчитан ваш клиент
public class TurkeyAdapter implements Duck {
    //ссылка на адаптируемый объект
    Turkey turkey;

                        //получаем ссылку
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

//Адаптер должен реализовать все методы интерфейса
    public void quack() {
        //Простое преобразование, с вызовом метода.
        turkey.gobble();
    }

    public void fly() {
        //Сложное преобразование, с выполнением дополнительного кода
        for(int i=0; i < 5; i++) {
            //Вызовем полет пять раз, индюшка плохо летает
            turkey.fly();
        }
    }
}