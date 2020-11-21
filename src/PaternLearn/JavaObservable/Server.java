package PaternLearn.JavaObservable;

import java.util.Observable;
import java.util.Observer;

public class Server extends Observable {
    private String ping;

    public Server() {
        // Описывать сервер не надо, берем готовый из Ява библиотеки
    }

    // Готовые методы из Ява библиотеки
    public void dataChanged() {
        // Обязательно вызывает метод перед рассылкой
        setChanged();
        // Если () пустые, объект не передается, то это модель запроса данных
        notifyObservers();
    }

    public void setData(String ping) {
        this.ping = ping;
        dataChanged();
    }

    // Метод для наблюдателей, которые будут им забирать данные
    public String getPing() {
        return ping;
    }
}
