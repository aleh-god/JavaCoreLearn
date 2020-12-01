package PaternLearn.ListenerLearn;

// Имплементирует два интерфейса - для прослушки, для отображения виджета.
public class CurentDisplay implements Display, Observer {
    private float temp;
    private float pressure;
    private float humidity;
    // Ссылка на сервер
    private Subject weatherData;

    // В конструктор прописываем объект сервера данных, который используется
    // для регистрации элемента в качестве наблюдателя
    public CurentDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(float temp, float pressure, float humidity) {
        // Сначало забираем свежие данные, потом вызываем виджет
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        // Одна из реализаций виджета
        System.out.println("Current data: " + temp + ", " + pressure + ", " + humidity + ".");
    }
}
