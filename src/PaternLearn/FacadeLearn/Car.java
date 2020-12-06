package PaternLearn.FacadeLearn;

//Приведенный ниже класс Car демонстрирует все возможности вызова методов, соответствующие принципу минимальной информированности.
public class Car {
    // Компонент класса, можем использовать его методы.
    Engine engine;

    public Car() {
        // Инициализация
    }

                //Принимаем объект как параметр, можем использовать его методы.
    public void start(Key key) {

        // Создамем объект внутри, можем использовать его методы.
        Doors doors = new Doors();

        // Все методы по принципу минимальной информированности.
        boolean authorized = key.turns();
        if (authorized) {
            engine.start();
            updateDashboardDisplay();
            doors.lock();
        }
    }
    // Внутренний метод класса, его можно использовать.
    public void updateDashboardDisplay() {
        // Перерисовка экрана
    }
}
