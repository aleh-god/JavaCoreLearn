package PaternLearn.DecoratorLearn;

public abstract class Beverage {
    //Вместо стринг можно вставить Array с которым можно проводить сложные манипуляции
    String description = "Null beverage";

    public String getDescription() {
        return description;
    }

    //Метод будем реализовывать в суб-классах
    public abstract double cost();
}
