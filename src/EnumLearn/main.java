package EnumLearn;

public class main {
    private static String text;

    // Просто перечисление
    enum Cat {Leopard, Lion, Manul, Puma, Tiger}

    // Перечисления можно объявлять как полноценный класс с методами
    enum Environment
    {
        PROD("Java is easy to learn!"),
        SIT("Java is object-oriented!"),
        CIT("Java is platform-independent!");

        private String url;

        // Конструктор
        Environment(String envUrl) {
        this.url = envUrl;
    }
        // Геттер
        public String getUrl() {
        return url;
    }
    }

    public static void main(String[] args) {
        // Идентификаторы в фигурных скобках называются константами перечисления. Каждый из них явно объявлен как открытый статический финальный член класса Cat.
        // Создаем объект(переменную) без оператора new, а в упрощенном виде.
        Cat manul;
        // Вы можете присвоить переменной только те значения, которые определены в перечислении, например:
        manul = Cat.Manul;
        Cat nexta = Cat.Puma;

        if (manul == Cat.Manul) {
            System.out.println("Погладь кота, ...");
        }
        System.out.println("\n");

        String result = "";

        switch (nexta) {
            case Leopard:
                result = "Я леопард";
                break;
            case Puma:
                result = "Я пума";
                break;
            case Lion:
                result = "Я царь зверей";
                break;
            case Tiger:
                result = "Я тигра";
                break;
            case Manul:
                result = "Погладь кота, ...";
                break;
        }
        System.out.println(result);
        System.out.println("\n");

    // Автоматически предопределённый метод для перечисления values() возвращает массив, содержащий список констант перечисления.

        Cat[] allcats = Cat.values(); // дополнительная переменная allcats, которой присваивается ссылка на массив перечислимых значений

    // for(тип итер_пер : коллекция) блок_операторов
    	for(Cat cat : allcats) {
        System.out.println(cat);
	    }
        System.out.println("\n");

        // значение, которое указывает позицию константы в списке констант перечисления (порядковое значение или ordinal value), с помощью метода ordinal(). Порядковые значения начинаются с нуля.
        for(Cat cat : Cat.values()) {
            System.out.println(cat + " Его порядковое значение: " + cat.ordinal());
        }
        System.out.println("\nМетод для перечисления valueOf()");

        // Автоматически предопределённый метод для перечисления valueOf() возвращает константу перечисления, значение которой соответствует строке, переданной в параметре.
        Cat Pum;
        Pum = Cat.valueOf("Puma");
        System.out.println(Pum);
        System.out.println("\nЦикл for:");

        // Цикл for
        // for(инициализация; логическое выражение (условие); шаг (итерация)) команда;

        for (int x = 0; x < 9; x = x + 2) System.out.println("Значение x: " + x);
        System.out.println("\n");
        for (int x = 5; x >= 0; x--) System.out.println("Значение y: " + x);

        System.out.println("\nИспользование нескольких переменных:");
        // Использование нескольких переменных
        int a, b;
        b = 6;

        for(a = 1; a < b; a++) {
            System.out.println("a = " + a + " b = " + b);
            b--;
        }

        // Работа с массивами
        System.out.println("\nРабота с массивами:");
        int[] mice = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < mice.length; i++)
            System.out.print(" " + mice[i]);

        System.out.println("\nКомпактная форма for:");
        // при таком способе исключается возможность ошибок выхода за пределы массива.
        int[] nums = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for(int i : nums) {
            sum += i;
            if (i == 3) break; // останавливаем цикл с помощью оператора break, если значение равно 3
        }
        System.out.print("Сумма равна " + sum + "\n");

        // Поиск значения в неупорядоченном массиве. Поиск прекращается после обнаружения нужного значения.
        int[] numsRand = { 3, 1, 6, 4, 9, 5, 8, 2 };

        int val = 5;
        boolean found = false;

        // ищем значение 5 в массиве
        for (int x : numsRand) {
            if (x == val) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Значение найдено:" + val);
        }

        // Вложенные циклы
        System.out.println("\nВложенные циклы:");
        int i, j;

        for (i = 0; i < 10; i++) {
            for (j = i; j < 10; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println("\nТаблица умножения:");

        a = 0;

        for (i = 1; i < 10; i++) {
            for (j = 1; j < 10; j++) {
                a = i * j;
                System.out.print(i + " * " + j + " = " + a + " | ");
            }
            System.out.println();
        }

        // Треугольник Флойда
        System.out.println("\nТреугольник Флойда:");
        a = 55;
        val = 0;

        for (i = 1; i < a; i++) {
            for (j = 1; j < i; j++) {
                val++;
                System.out.print(val + " ");
                if (val == a) break;
            }
            System.out.print("\n");
            if (val == a) break;
        }


        //Get all enums
        for(Environment env : Environment.values())
        {
           for(i = 1; i < 5; i++) System.out.println(env.getUrl());
        }
    }
}

