package StringLearn;

import java.util.Scanner;

public class main {
    public static void main(String[] agrs) {
        // Следует помнить, что объекты класса String являются неизменяемыми (immutable). Поэтому, когда вам кажется, что вы меняете строку, то на самом деле вы создаёте новую строку.
        System.out.println("Классы String, StringBuffer, StringBuilder");

        // Создать строку очень просто. Например, можно так:
        String aboutCat = "Кот - это звучит гордо, а если наступить на хвост, то громко";

        //Можно создать массив строк:
        String[] cats = {"Васька", "Барсик", "Мурзик"};

        //Можно создать пустой объект класса String:
        String str = new String();
        System.out.println(str);

        //Можно создать строку через массив символов:
        char[] chars = { 'c', 'a', 't' };
        String massStr = new String(chars);
        System.out.println("Можно создать строку через массив символов: " + massStr);

        //Есть ещё конструктор, позволяющий задать диапазон символьного массива. Вам нужно указать начало диапазона и количество символов для использования:
        char[] charsDiap = {'w', 'q', 'c', 'a', 't', 'v', 'r', 'a', 'm' };
        String overMassStr = new String(charsDiap, 2, 3);
        System.out.println(overMassStr);

        // Можно создать объект класса String из объекта классов StringBuffer и StringBuilder при помощи следующих конструкторов:
        // String(StringBuffer объект_StrBuf)
        // String(StringBuilder объект_StrBuild)

        /* Если один из операндов в выражении содержит строку, то другие операнды также должны быть строками.
         Поэтому Java сама может привести переменные к строковому представлению, даже если они не являются строками.
         */
        int digit = 4;
        String paws = " лапы";
        String aboutcat = digit + paws;
        System.out.println(aboutcat);

    /* <string name="aboutcat">У кота по имени Барсик четыре лапы, один хвост. Ему 5 лет</string>

           Чтобы вывести эту строку программно в элементе TextView, можно использовать код:
           Нужно определить слова, которые мы будем менять и заменить их на специальный набор символов,
         которые начинаются с символа процента, затем идет число, увеличивающееся на единицу,
          далее $s для строк или $d для чисел. Итак, изменим наш строковой ресурс так:

       <string name="aboutcat">У кота по имени %1$s %2$s лапы, %3$s хвост. Ему %4$d лет</string>
                Внесём изменения в код:


        String strBarsik = "Барсик";
        String strPaws = "четыре";
        String strTail = "один";
        int year = 5;
        // String strCats = "У кота по имени " + %1$s + %2$s + "лапы, " + %3$s + "хвост. Ему " + %4$d + "лет";
        String strCats = "У кота по имени ";
        String strFinal = String.format(strCats, strBarsik, strPaws, strTail, year);
        System.out.println(strFinal);
        // Если вас есть кот Васька и ему шесть лет, то добавляем две переменные и форматируем строку


        String strVaska = "Васька";
        year = 6;
        strFinal = String.format(strCats, strVaska, strPaws, strTail, year);
        System.out.println(strFinal);*/

        String testString = "Котёнок";
        char myChar = testString.charAt(2); // Возвращает символ с указанным смещением в этой строке. Отсчёт идёт от 0.
        System.out.println(myChar); // выводит третий символ - т
        int myIntChar = testString.codePointAt(3);
        System.out.println(myIntChar); // возвращает 1105

        // Вычисляет количество Unicode-символов между позициями start и end
        myIntChar = testString.codePointCount(0, 3);
        System.out.println(myIntChar); // возвращает 3

        // public int compareTo(String string)
        // Сравнивает указанную строку, используя значения символов Unicode и вычисляет, какая из строк меньше, равна или больше следующей. Может использоваться при сортировке. Регистр учитывается. Если строки совпадают, то возвращается 0, если меньше нуля, то вызывающая строка меньше строки string, если больше нуля, то вызывающая строка больше строки string. Слова с большим регистром стоят выше слова с нижним регистром.

        if (testString.compareTo("котёнок") == 0) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны. Возвращено"
                    + testString.compareTo("котёнок")); // возвращает -32
        }

        //         Отсортируем массив строк через пузырьковую сортировку.
        String[] poem = { "Мы", "везём", "с", "собой", "кота" };

        for (int j = 0; j < poem.length; j++) {
            for (int i = j + 1; i < poem.length; i++) {
                if (poem[i].compareTo(poem[j]) < 0) {
                    String temp = poem[j];
                    poem[j] = poem[i];
                    poem[i] = temp;
                }
            }
            System.out.println(poem[j]);
        }

        // public boolean contains (CharSequence cs)
        // Определяет, содержит ли строка последовательность символов в CharSequence

        testString = "котёнок";

        if(testString.contains("кот")){
            System.out.println("В слове котёнок содержится слово кот!");
        }

        // public static String copyValueOf(char[] data)
        // Создаёт новую строку, содержащую символы из указанного массива. Изменение массива после создания строки не изменяет созданную строку.


        char[] textArray = {'I', ' ', 'l', 'o', 'v', 'e', ' ', 'c', 'a', 't', 's'};
        String newString = String.copyValueOf(textArray);
        System.out.println(newString);

        System.out.println("\nКлассы StringBuffer и StringBuilder");
        // Данный класс гораздо экономичнее в плане потребления памяти и настоятельно рекомендуется к использованию.

        StringBuffer sb = new StringBuffer("КотээээЭэээЭээЭ"); // Конструктор StringBuffer() - резервирует место под 16 символов без перераспределения памяти
        System.out.println(sb);

        System.out.println("Метод позволяет получить текущую длину объекта: " + sb.length());

        sb.setLength(4);
        System.out.println("Устанавливает длину строки. Значение должно быть неотрицательным: " + sb.length());
        System.out.println(sb);

        // Можно извлечь значение отдельного символа с помощью метода charAt() и установить новое значение символа с помощью метода setCharAt(), указав индекс символа и его значение.
        sb = new StringBuffer("Кит");
        sb.setCharAt(1, 'o');
        System.out.println(sb.toString());

        // Метод соединяет представление любого другого типа данных.
        String str1 = "У кота ";
        String str2 = " лапы";
        int paw = 4;
        sb = new StringBuffer(20);
        sb.append(str1).append(paw).append(str2);
        System.out.println(sb.toString());

        // Вставляет одну строку в другую.
        // Также можно вставлять значения других типов, которые будут автоматически преобразованы в строки.
        // Вам надо указать индекс позиции, куда будет вставляться строка.
        sb = new StringBuffer("Я Котов");
        sb.insert(2, "Люблю ");
        System.out.println(sb.toString());

        // Позволяет изменить порядок символов на обратный.
        sb = new StringBuffer("МОКНЕТ ОКСАНА С КОТЕНКОМ");
        sb.reverse();
        System.out.println(sb.toString());

        StringBuilder builder = new StringBuilder();

        builder.append("I"); // можно добавить один символ
        builder.append(" sameText"); // а можно добавить готовую строку
        String completedString = builder.toString(); // результирующая строка
        System.out.println(completedString);
        // Соединять строки можно цепочкой.
        // new StringBuilder().append(s1).append(s2).append(s3).toString();

        // Класс Scanner упрощает разбор строки из потока ввода
        // Простейший пример разбивки предложения на отдельные слова.
        Scanner scanner = new Scanner("Кот Васька 28 Москва");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        // Получим число.
        scanner = new Scanner("27");
        System.out.println(scanner.nextInt()); // 27

/*        Кроме спецификатора %d мы можем использовать еще ряд спецификаторов для других типов данных:

%x: для вывода шестнадцатеричных чисел
%f: для вывода чисел с плавающей точкой
%e: для вывода чисел в экспоненциальной форме, например, 1.3e+01
%c: для вывода одиночного символа
%s: для вывода строковых значений
 */
        String name = "Tom";
        int age = 30;
        float height = 1.7f;

        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
    }
}
