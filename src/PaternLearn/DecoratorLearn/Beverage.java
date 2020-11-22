package PaternLearn.DecoratorLearn;

public abstract class Beverage {
    String description = "Null beverage";

    public String getDescription() {
        return description;
    }

    //Метод будем реализовывать в суб-классах
    public abstract double cost();
}
