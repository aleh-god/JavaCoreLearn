package PaternLearn.ShablonLearn;

//Расширяем класс, что бы воспользоваться final и общими методами рецепта
public class Tea extends CaffeineBeverage {

    //Уникальные методы для рецепта определяем самостоятельно
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}