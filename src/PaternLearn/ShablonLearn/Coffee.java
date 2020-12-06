package PaternLearn.ShablonLearn;

//Расширяем класс, что бы воспользоваться final и общими методами рецепта
public class Coffee extends CaffeineBeverage {

    //Уникальные методы для рецепта определяем самостоятельно
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
