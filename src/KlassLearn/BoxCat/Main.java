package Home.GOD;
// Импорт стаических математ методов
// import static java.lang.Math.sqrt; - отдельно
// import static java.lang.Math.*; - или полностью

public class Main {

    public static void main(String[] args) {
	// write your code here
        double testMath;

        Box catBox = new Box();
        System.out.println("Объём простой коробки: " + catBox.getVolume());
        MegaBox dogBox = new MegaBox();
        dogBox.setDim(10, 20, 30);
        System.out.println("Объём сложной коробки: " + dogBox.getVolume());

        Box box1 = new Box(10, 20, 30);
        Box cloneBox = new Box(box1);

        int vol = cloneBox.getVolume();
        System.out.println("Объём клонированной коробки: " + vol);

        // Наследование тяжелой коробки от обычной
        HeavyBox box = new HeavyBox(15, 10, 20, 5);
        int vol2 = box.getVolume(); // мы вызываем метод getVolume(), который не прописывали в классе HeavyBox, но наследовали
        System.out.println("Объём коробки: " + vol2 + " Вес коробки: " + box.weight);

        // Использование static переменных и методов
        System.out.println(StaticCat.sId + "");
        System.out.println(StaticCat.sTestNumber + "");

        // Создаём первого кота
        StaticCat firstCat = new StaticCat("vasya", 2);
        System.out.println(StaticCat.sId + "");
        System.out.println(StaticCat.sTestNumber + "");

        StaticCat.sTestNumber = 15; // устанавливаем новое значение

        // Создаём второго кота
        StaticCat secondCat = new StaticCat("murzik", 12);
        System.out.println(StaticCat.sId + "");
        System.out.println(StaticCat.sTestNumber + "");

        // Наследование классов и переопределение методов
        Cat batsik = new Cat ();
        System.out.println(batsik.sleep());

        // Наследование классов и переопределение методов
        Figure figure = new Figure(10, 10);
        // Создаем объекты из наследуемых классов
        Rectangle rectangle = new Rectangle(8, 5);
        Triangle triangle = new Triangle(10, 6);

        // Во всех классах используется одно и тоже имя метода, но каждый класс по своему вычисляет площадь в зависимости от фигуры.
        Figure fig;
        // Ссылку на объект мастеркласса можно заменять ссылками на объекты подклассов rectangle и triangle
        fig = figure;

        // Во всех классах используется одно и тоже имя метода, но каждый класс по своему вычисляет площадь в зависимости от фигуры.
        System.out.println("Площадь равна " + fig.area());
        fig = rectangle;
        System.out.println("Площадь равна " + fig.area());
        fig = triangle;
        System.out.println("Площадь равна " + fig.area());



        // instanceof - Проверка принадлежности к классу.  Это булев оператор, и выражение foo instanceof Foo истинно, если объект foo принадлежит классу Foo или его наследнику, или реализует интерфейс Foo (или, в общем виде, наследует класс, который реализует интерфейс, который наследует Foo).
        IrishCat nemo = new IrishCat();

        if(nemo instanceof Cat) {
            System.out.println("Немо относится к классу котов");
            // это может быть класс Cat (родительский класс) или подкласс типа IrishCat

            if(nemo instanceof IrishCat) {
                System.out.println("Немо  - это ирландец!");
            }
        }

        // Cтатический импорт, применяемый для импорта статических членов класса или интерфейса.
        testMath = Math.sqrt(Math.pow(vol, 2) + Math.pow(vol, 2));
        System.out.println("Результат: " + testMath);


       //
    }

}
