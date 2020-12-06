package PaternLearn.AdapterLearn;

public class Main {
    public static void main(String[] agrs) {
        //Создаем объект Duck
        MallardDuck duck = new MallardDuck();
        //объект Turkey
        WildTurkey turkey = new WildTurkey();
        //Затем Turkey упаковывается в TurkeyAdapter и начинает выглядеть, как Duck
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        //
        Turkey duckAdapter = new DuckAdapter(duck);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();
        System.out.println("\nThe Duck says...");
        testDuck(duck);

        //выдаем Turkey за Duck
        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);

        //выдаем Duck за Turkey
        System.out.println("\nThe DuckAdapter says...");
        testTurkey(duckAdapter);
    }

    static void testDuck(Duck duck) {
        System.out.println("\nTest Duck object:");
        duck.quack();
        duck.fly();
    }

    static void testTurkey(Turkey turkey) {
        System.out.println("\nTest Turkey object:");
        turkey.gobble();
        turkey.fly();
    }
}