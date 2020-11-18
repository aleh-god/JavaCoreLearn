package CollectionsAllLearn.CollectionLearn;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/* Collection - это интерфейс

Два основных метода интерфейса:
boolean add(E element) - добавить элемент
Iterator<E> iterator() - для прохождения по элементам

Метод add() добавляет элемент в коллекцию и возвращает логическое значение true, если добавление изменило коллекцию.

Метод iterator() возвращает объект класса, реализующего интерфейс Iterator.

Метод toString() выводит содержимое коллекции в квадратных скобках, с разделением элементов запятыми.
 */

public class main {
    public static void main(String[] agrs) {
        // Мы объявили экземпляр класса ArrayList под именем catNames
        // Такой объект класса может запихивать в себя любые поля, но при чтении выдаст ошибку
        ArrayList catNamesBad = new ArrayList();
        // Поэтому правильно указывать тип для объекта массива
        ArrayList<String> catNames = new ArrayList<>();
        // В обобщениях можно использовать только объекты классов. Поэтому запись ArrayList<int> не прокатит. В таких случаях следует использовать класс Integer: ArrayList<Integer>
        // Емкость, если необходимо
        catNames.ensureCapacity(10);

        // Первоначальную ёмкость можно задать и в конструкторе в качестве параметра.
        ArrayList<Cat> cats = new ArrayList<>(10);
        cats.add(new Cat("Васька"));
        cats.add(new Cat("Барсик"));

        // метод add() добавили имя
        catNames.add("Васька");
        // первый элемент массива через индекс, равный 0
        System.out.println(catNames.get(0));
        catNames.add("Мурзик");
        catNames.add("Рыжик");
        catNames.add("Мурзик");
        catNames.add("Рыжик");
        // Чтобы получить имя последнего кота в массиве, нужно получить размер массива и отнять единицу
        System.out.println("Последний котик: " + catNames.get(catNames.size() - 1));

        // Метод indexOf(), который ищет подходящий элемент и выводит его индекс
        int index = catNames.indexOf("Рыжик");

        // выводим имя кота и его номер в массиве
        System.out.println("Рыжик числится под индексом " + index);

        // Просмотр всех элементов

        String catName = "";
        // String name - это переменная которая будет использоваться в цикле ФОР. Идекс-переменная скрыта в укороченной записи цикла
        for (String name : catNames) {
            catName = catName + name + " ";
        }
        System.out.println("Все коты: " + catName);

        // Чтобы узнать, есть в массиве какой-либо элемент, можно воспользоваться методом contains(), который вернёт true или false
        System.out.println("Есть ли Бобик? Ответ - " + catNames.contains("Бобик"));

        // Замена элемента
        catNames.set(1, "Мурка");

        // Для удаления элемента из массива используется метод remove(). Можно удалять по индексу или по объекту
        catNames.remove(0); // удаляем по индексу
        catNames.remove("Васька"); // удаляем по объекту
        // Метод removeAll() удаляет сразу все элементы. Но лучше использовать метод clear().

        // Метод removeIf() - удаление элемента по предикату
        ArrayList<Integer> numList = new ArrayList<>();
        // Оригинал: [51, 14, 11, 12, 31, 21]
        numList.add(51);
        numList.add(51);
        numList.add(51);
        numList.add(14);
        numList.add(11);
        numList.add(12);
        numList.add(31);
        numList.add(21);

        System.out.println("Оригинал: " + numList.toString());
        // удаляем элементы, которые больше 10 и меньше 20
        numList.removeIf(i -> (i > 10 && i < 20));

        System.out.println("Новый список: " + numList.toString());

        System.out.println("Все коты: " + catName);
        int count = Collections.frequency(numList, 51); // Сколько раз совпадают элементы
        System.out.println("Колличество 51: " + String.valueOf(count)); // выводим результат в TextView

        // С помощью библиотеки Apache Commons Collections можно объединить два ArrayList.

        List<String> listA = new ArrayList<String>();
        listA.add("Васька");
        listA.add("Барсик");
        listA.add("Мурзик");

        List<String> listB = new ArrayList<String>();
        listB.add("Пушок");
        listB.add("Снежок");
        listB.add("Рыжик");

        // объединяем два списочных массива
        // List<String> listAB = ListUtils.union(listA, listB);

        System.out.println("listA : "  + listA);
        System.out.println("listB : "  + listB);
        // System.out.println("listAB : " + listAB);

        //Сортировать элементы можно при помощи метода Collections.sort().
        List<String> items = new ArrayList<>();

        items.add("d");
        items.add("c");
        items.add("b");
        items.add("a");

        Collections.sort(items);

        System.out.println(items.toString());

    }
}
