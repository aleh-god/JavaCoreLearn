package PaternLearn.DecoratorLearn;

//Каждый напиток расширяется от абстрактного класса
public class Espresso extends Beverage {

    public Espresso() {
        // Описание задаем в конструкторе. Переменная от абстр класса
        description = "Espresso";
    }

    // Простая формула, которая просто возвращает стоимость напитка
    public double cost() {
        return 1.99;
    }
}
