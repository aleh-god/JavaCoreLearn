package PaternLearn.ListenerLearn;

public class Main {
    public static void main(String[] agrs) {
        // Создаем сервер
        WeatherData weatherData = new WeatherData();
        // Создаем виджет
        CurentDisplay curentDisplay = new CurentDisplay(weatherData);

        //Задаем данные с датчика погоды
        System.out.println("Погода день 1.");
        weatherData.setMeasurement(10, 1, 100);
        System.out.println("Погода день 2.");
        weatherData.setMeasurement(12, 2, 200);
        System.out.println("Погода день 3.");
        weatherData.setMeasurement(13, 3, 300);
    }
}
