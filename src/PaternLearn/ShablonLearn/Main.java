package PaternLearn.ShablonLearn;

public class Main {
    public static void main(String[] agrs) {
        Tea teaHook = new Tea();
        Coffee coffee = new Coffee();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
        System.out.println("\nMaking coffee with milk and sugar...");
        coffeeHook.prepareRecipe();
    }
}
