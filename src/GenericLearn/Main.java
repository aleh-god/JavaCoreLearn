package GenericLearn;

public class Main {
    public static void main(String[] agrs) {

// Работаем с обобщённым классом

        // Создаём Gen-ссылку для Integer - Создаем версию класса Generic для целых чисел
        Generic<Integer> iOb;
        // все ссылки на тип T становятся ссылками на тип Integer

        // Создаём объект Gen<Integer>
        iOb = new Generic<Integer>(77);

        // Показать тип данных, используемый iOb
        iOb.showType();

        // Получить значение iOb. Технически по обе стороны = одинаковые объекты описанные по разному и созданные по разному
        int value = iOb.getob();
        System.out.println("Значение " + value);

        // Создадим объект Gen для String
        Generic<String> strOb = new Generic<String>("Обобщённый текст");

        // Показать тип данных, используемый strOb
        strOb.showType();

        // Получить значение strOb
        String str = strOb.getob();
        System.out.println("Значение: " + str);

        System.out.println("\nОбобщённый класс с двумя параметрами");

// Можно указать два и более параметров типа через запятую.
// Используем созданный класс
        TwoGen<Integer, String> twogenObj = new TwoGen<Integer, String>(77, "Обобщённый текст");

        // Узнаем типы
        twogenObj.showTypes();

        // Узнаем значения
        value = twogenObj.getob1();
        System.out.println("Значение: " + value);

        str = twogenObj.getob2();
        System.out.println("Значение: " + str);

        // Под Android вам часто придётся использовать списочный массив, который использует обобщещние.
        // ArrayList<String> catNames = new ArrayList<String>();
    }
}