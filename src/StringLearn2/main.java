package StringLearn2;

public class main {
    public static void main(String[] agrs) {
//Строка представляет собой последовательность символов. Для работы со строками в Java определен класс String,
// который предоставляет ряд методов для манипуляции строками. Физически объект String представляет собой
// ссылку на область в памяти, в которой размещены символы.
//Для создания новой строки мы можем использовать один из конструкторов класса String,
// либо напрямую присвоить строку в двойных кавычках:
            String str1 = "Java";
            String str2 = new String(); // пустая строка
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

        String str = "Hello world!";
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

    }
}