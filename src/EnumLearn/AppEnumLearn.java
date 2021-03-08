package EnumLearn;

public class AppEnumLearn {
    private static String text;

    // Просто перечисление
    enum Cat {Leopard, Lion, Manul, Puma, Tiger}

    // Перечисления, как и обычные классы, могут определять конструкторы, поля и методы.
    enum Environment
    {
        PROD("Java is easy to learn!"),
        SIT("Java is object-oriented!"),
        CIT("Java is platform-independent!");
        // Закрытое поле для хранения
        private String url;

        // закрытый по умолчанию Конструктор
        Environment(String envUrl) {
        this.url = envUrl;
    }
        // Геттер
        public String getUrl() {
        return url;
    }
    }

    enum Color{
        /**
         * Перечисление Color определяет приватное поле code для хранения кода цвета, а с помощью метода getCode оно возвращается.
         * Через конструктор передается для него значение. Следует отметить, что конструктор по умолчанию приватный, то есть имеет модификатор private.
         * Любой другой модификатор будет считаться ошибкой. Поэтому создать константы перечисления с помощью конструктора мы можем только внутри перечисления.
         */
        RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");
        // Закрытое поле для хранения
        private String code;
        // закрытый по умолчанию Конструктор
        Color(String code){
            this.code = code;
        }
        // Геттер
        public String getCode(){ return code;}
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

        // Удобно использовать в case
        String result = "No Null Exception";
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

    // Каждое перечисление имеет статический метод values(). Он возвращает массив всех констант перечисления:

        Cat[] allcats = Cat.values(); // дополнительная переменная allcats, которой присваивается ссылка на массив перечислимых значений
        // Результат
    	for (Cat cat : allcats) { // for(тип итер_пер : коллекция) блок_операторов
            System.out.print(cat + " ");
	    }
        System.out.println("\n");

        // Значение, которое указывает позицию константы в списке констант перечисления (порядковое значение или ordinal value), с помощью метода ordinal(). Порядковые значения начинаются с нуля.
        // Метод ordinal() возвращает порядковый номер определенной константы (нумерация начинается с 0):
        for(Cat cat : Cat.values()) {
            System.out.println(cat + " Его порядковое значение: " + cat.ordinal());
        }
        System.out.println("\nМетод для перечисления valueOf()");

        // Автоматически предопределённый метод для перечисления valueOf() возвращает константу перечисления, значение которой соответствует строке, переданной в параметре.
        Cat Pum;
        Pum = Cat.valueOf("Puma");
        System.out.println(Pum);

        // Вызов значений Enum через геттер
        for(Environment env : Environment.values()) {
            System.out.println(env.getUrl());
        }

        System.out.println(Color.RED.getCode());        // #FF0000
        System.out.println(Color.GREEN.getCode());      // #00FF00

    }
}

