package PaternLearn.ListenerLearn;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private float temp;
    private float pressure;
    private float humidity;
    private ArrayList observers;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void addObserver(Observer o) {
        System.out.println("Наблюдатель добавлен.");
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        // Находим индекс ключевого объекта
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        for (int j = 0 ; j < observers.size() ; j++) {
            // Берем объект из списка Arraylist по порядку
            Observer observer = (Observer)observers.get(j);
            // Ключевой метод из интерфеса, которые наследуют слушатели
            observer.update(temp , pressure , humidity);
        }
    }

    public void measurementChanged() {
        // Когда изменяются данные, запускаем оповещение
        notifyObserver();
    }

    // Сюда придут данные с основного кода
    public void setMeasurement (float temp, float pressure, float humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementChanged();
    }
}
