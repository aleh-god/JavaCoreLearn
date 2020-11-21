package PaternLearn.JavaObservable;
import PaternLearn.ListenerLearn.Display;


import java.util.Observable;
import java.util.Observer;

public class Vijet implements Observer, Display {

    private Observable observable;
    String ping = "Я пустой";

    public Vijet(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    // Какой объект на связи, Какую инфу передает
    public void update(Observable obs, Object arg) {
        System.out.println("Второй виджет");
        // Проверяем какому классу принадлежит объект
        if (obs instanceof Server) {
            Server server = (Server)obs;
            this.ping = server.getPing();
            System.out.println("Второй пинг");
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(ping);
    }
}
