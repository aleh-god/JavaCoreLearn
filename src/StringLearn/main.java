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

//Строка представляет собой последовательность символов. Для работы со строками в Java определен класс String,
// который предоставляет ряд методов для манипуляции строками. Физически объект String представляет собой
// ссылку на область в памяти, в которой размещены символы.
//Для создания новой строки мы можем использовать один из конструкторов класса String, либо напрямую присвоить строку в двойных кавычках:
        //String
        str1 = "Java";
        str2 = new String(); // пустая строка
        String str3 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        String str4 = new String(new char[]{'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3, 4);
        //3 -начальный индекс, 4 -кол-во символов
        System.out.println(str1); // Java
        System.out.println(str2); //
        System.out.println(str3); // hello
        System.out.println(str4); // come
        //При работе со строками важно понимать, что объект String является неизменяемым (immutable).
        // То есть при любых операциях над строкой, которые изменяют эту строку, фактически будет создаваться новая строка.
        //Поскольку строка рассматривается как набор символов, то мы можем применить метод length() для нахождения длины строки или длины набора символов:
        System.out.println("Длина строки " + str1.length()); // 4
        //А с помощью метода toCharArray() можно обратно преобразовать строку в массив символов:
        str1 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        char[] helloArray = str1.toCharArray();

        //Строка может быть пустой. Для этого ей можно присвоить пустые кавычки или удалить из стоки все символы:
        String s = "";   // строка не указывает на объект
        if (s.length() == 0) System.out.println("String is empty");

        //Класс String имеет специальный метод, который позволяет проверить строку на пустоту - isEmpty().
        //Если строка пуста, он возвращает true:
        if (s.isEmpty()) System.out.println("String is empty");

        //Переменная String может не указывать на какой-либо объект и иметь значение null:
        s = null;   // строка не указывает на объект
        if (s == null) System.out.println("String is null");

        //Так как переменная не указывает ни на какой объект String, то соответственно мы не можем обращаться
        // к методам объекта String. Чтобы избежать подобных ошибок, можно предварительно проверять строку на null:
        s = null;   // строка не указывает на объект
        if (s != null && s.length() == 0) System.out.println("String is empty");

        //Фактически же при сложении строк с нестроковыми объектами будет вызываться метод valueOf() класса String.
        //Данный метод имеет множество перегрузок и преобразует практически все типы данных к строке.
        //Для преобразования объектов различных классов метод valueOf вызывает метод toString() этих классов.

        str1 = "Java";
        str2 = "Hello";
        str2 = str2.concat(str1); // concat(): объединяет строки
        str3 = String.join(" ", str2, str1); // join(): соединяет строки с учетом разделителя
        str1 = "Java";
        char c = str1.charAt(2);
        System.out.println(c); // charAt(): возвращает символ строки по индексу

        str = "Hello world!";
        int start = 6;
        int end = 11;
        char[] dst=new char[end - start];
        str.getChars(start, end, dst, 0);
        System.out.println("Берем группу символов между 6-11: ");
        System.out.println(dst); // world

        str1 = "Hello";
        str2 = "hello";
        System.out.println("\nСравнение " + str1 + " и " + str2 + " с учетом регистра " + str1.equals(str2)); // false
        System.out.println("Сравнение " + str1 + " и " + str2 + " без учета регистра " + str1.equalsIgnoreCase(str2)); // true

        str1 = "Hello world";
        str2 = "I work";
        boolean result = str1.regionMatches(6, str2, 2, 3);
        System.out.println("\nМетод сравнивает 3 символа с 6-го индекса первой строки (\"wor\") и 3 символа со 2-го индекса второй строки (\"wor\")." + result); // true

        str = "Hello world";
        int index1 = str.indexOf('l'); // 2
        System.out.println("\nВ строке: " + str + " первая позиция символа l равна: " + index1);
        int index2 = str.indexOf("wo"); //6
        System.out.println("В строке: " + str + " первая позиция символов wo равна: " + index2);
        int index3 = str.lastIndexOf('l'); //9
        System.out.println("В строке: " + str + " последняя позиция символа l равна: " + index3);

        str = "myfile.exe";
        boolean startW = str.startsWith("my"); //true
        boolean endW = str.endsWith("exe"); //true
        System.out.println("\nОпределяет, начинается ли строка " + str + " с подстроки my = " + startW);
        System.out.println("Определяет, заканчивается ли строка " + str + " подстрокой exe = " + startW);

        System.out.println("\nМеняем в строке " + str + " символ m и символы file:");
        String replStr1 = str.replace('m', 'b'); //
        String replStr2 = replStr1.replace("file", "life"); //
        System.out.println("Результат: " + replStr2);

        replStr1 = replStr2.substring(2);
        System.out.println("\nвозвращает подстроку, начиная после определенного индекса (2) до конца: " + replStr1);
        replStr1 = replStr2.substring(2,6);
        System.out.println("Возвращает подстроку в диапазоне 3-5: " + replStr1);
        System.out.println("Переводит все символы строки в верхний регистр: " + replStr1.toUpperCase());

        //Метод split() позволяет разбить строку на подстроки по определенному разделителю.
        // Разделитель - какой-нибудь символ или набор символов передается в качестве параметра в метод.
        System.out.println("\nРазбиваем текст в массив через заданный разделитель:");
        String text = "FIFA will never regret it";
        String[] words = text.split(" ");
        for(String word : words){
            System.out.println(word);
        }

        text = String.join("\\", words);
        System.out.println("Собираем строку занаво, назначаем новый разделитель: " + text);

        //классы StringBuffer и StringBuilder. По сути они напоминает расширяемую строку, которую можно изменять без ущерба для производительности.
        //Эти классы похожи, практически двойники, они имеют одинаковые конструкторы, одни и те же методы, которые одинаково используются. Единственное их различие состоит в том, что класс StringBuffer синхронизированный и потокобезопасный.
        // класс StringBuilder, который не потокобезопасный, но при этом работает быстрее, чем StringBuffer в однопоточных приложениях.

        //С помощью метода capacity() мы можем получить количество символов, для которых зарезервирована память. А с помощью метода ensureCapacity() изменить минимальную емкость буфера символов:
        str = "Java";
        StringBuffer strBuffer = new StringBuffer(str);
        System.out.println("Емкость: " + strBuffer.capacity()); // 20
        strBuffer.ensureCapacity(32);
        System.out.println("Емкость: " + strBuffer.capacity()); // 42
        System.out.println("Длина: " + strBuffer.length()); // 4
        /*
        Так как в самом начале StringBuffer инициализируется строкой "Java", то его емкость составляет 4 + 16 = 20 символов. Затем мы увеличиваем емкость буфера с помощью вызова strBuffer.ensureCapacity(32) повышаем минимальную емкость буфера до 32 символов. Однако финальная емкость может отличаться в большую сторону. Так, в данном случае я получаю емкость не 32 и не 32 + 4 = 36, а 42 символа. Дело в том, что в целях повышения эффективности Java может дополнительно выделять память.
        Но в любом случае вне зависимости от емкости длина строки, которую можно получить с помощью метода length(), в StringBuffer остается прежней - 4 символа (так как в "Java" 4 символа).
        Чтобы получить строку, которая хранится в StringBuffer, мы можем использовать стандартный метод toString():
        */

        strBuffer = new StringBuffer(str);
        // toString в скобках выполняется автоматически. Можно не писать.
        System.out.println(strBuffer.toString()); // Java

        //Получение и установка символов
        //Метод charAt() получает, а метод setCharAt() устанавливает символ по определенному индексу:

        strBuffer = new StringBuffer("Java");
        c = strBuffer.charAt(0); // J
        System.out.println(c);
        strBuffer.setCharAt(0, 'c');
        System.out.println(strBuffer.toString()); // cava

        //Метод getChars() получает набор символов между определенными индексами:
        strBuffer = new StringBuffer("world");
        int startIndex = 1;
        int endIndex = 4;
        char[] buffer = new char[endIndex-startIndex];
        strBuffer.getChars(startIndex, endIndex, buffer, 0);
        System.out.println(buffer); // orl

        //Метод append() добавляет подстроку в конец StringBuffer:
        strBuffer = new StringBuffer("hello");
        strBuffer.append(" world");
        System.out.println(strBuffer.toString()); // hello world

        //Метод insert() добавляет строку или символ по определенному индексу в StringBuffer:
        strBuffer = new StringBuffer("word");

        strBuffer.insert(3, 'l');
        System.out.println(strBuffer.toString()); //world

        strBuffer.insert(0, "s");
        System.out.println(strBuffer.toString()); //sworld

        //Метод delete() удаляет все символы с определенного индекса о определенной позиции, а метод deleteCharAt() удаляет один символ по определенному индексу:
        strBuffer = new StringBuffer("assembler");
        strBuffer.delete(0,2);
        System.out.println(strBuffer.toString()); //sembler

        strBuffer.deleteCharAt(6);
        System.out.println(strBuffer.toString()); //semble

        //Метод substring() обрезает строку с определенного индекса до конца, либо до определенного индекса:
        strBuffer = new StringBuffer("hello java!");
        str1 = strBuffer.substring(6); // обрезка строки с 6 символа до конца
        System.out.println(str1); //java!

        str2 = strBuffer.substring(3, 9); // обрезка строки с 3 по 9 символ
        System.out.println(str2); //lo jav

        //Для изменения длины StringBuffer (не емкости буфера символов) применяется метод setLength(). Если StringBuffer увеличивается, то его строка просто дополняется в конце пустыми символами, если уменьшается - то строка по сути обрезается:
        strBuffer = new StringBuffer("hello");
        strBuffer.setLength(10);
        System.out.println(strBuffer.toString()); //"hello     "

        strBuffer.setLength(4);
        System.out.println(strBuffer.toString()); //"hell"

        //Для замены подстроки между определенными позициями в StringBuffer на другую подстроку применяется метод replace():
        strBuffer = new StringBuffer("hello world!");
        strBuffer.replace(6,11,"java");
        System.out.println(strBuffer.toString()); //hello java!
        //Первый параметр метода replace указывает, с какой позиции надо начать замену, второй параметр - до какой позиции, а третий параметр указывает на подстроку замены.

        //Метод reverse() меняет порядок в StringBuffer на обратный:
        strBuffer = new StringBuffer("assembler");
        strBuffer.reverse();
        System.out.println(strBuffer.toString()); //relbmessa

/*
Кроме спецификатора %d мы можем использовать еще ряд спецификаторов для других типов данных:
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