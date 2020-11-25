package PaternLearn.DecoratorLearn;

// Абстрактный класс-декоратор. Наследуем от основного абстрактного класса
public abstract class CondimentDecorator extends Beverage {
    //Вместо стринг можно вставить Array с которым можно проводить сложные манипуляции
    public abstract String getDescription();
}