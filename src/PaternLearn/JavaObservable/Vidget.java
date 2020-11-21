package PaternLearn.JavaObservable;
import PaternLearn.ListenerLearn.Display;


import java.util.Observable;
import java.util.Observer;

public class Vidget implements Observer, Display {

    private Observable observable;
    String ping = "Я пустой";

    public Vidget(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
             // Какой объект на связи, Какую инфу передает
    public void update(Observable obs, Object arg) {
        System.out.println("Первый виджет");
        // Проверяем какому классу принадлежит объект
        if (obs instanceof Server) {
            Server server = (Server)obs;
            this.ping = server.getPing();
            System.out.println("Первый пинг");
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(ping);
    }
}
