package PaternLearn.DecoratorLearn;

// Создаем один из декораторов наследуясь от абстрактного декоратора
public class Mocha extends CondimentDecorator {
    // Создаем ссылку на абстрактный класс для использования полиморфизма
    Beverage beverage;

    // В конструктор кидаем ссылку на напиток для декоратора
    public  Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    // Сначало вызываем наследуемый метод и только потом добавляем свое описание.
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    // Сначало вызываем наследуемый метод и только потом добавляем свою стоимость.
    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
