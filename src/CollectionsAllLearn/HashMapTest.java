package CollectionsAllLearn;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {

        Map<Integer, String> states = new HashMap<Integer, String>();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");

        // получим объект по ключу 2
        String first = states.get(2);
        System.out.println(first);
        // получим весь набор ключей
        //Set<K> keySet(): возвращает набор всех ключей отображения
        Set<Integer> keys = states.keySet();
        // получить набор всех значений
        //Collection<V> values(): возвращает набор всех значений отображения
        Collection<String> values = states.values();
        //заменить элемент
        states.replace(1, "Poland");
        // удаление элемента по ключу 2
        states.remove(2);

        // перебор элементов
        //Set<Map.Entry<K, V>> entrySet(): возвращает набор элементов коллекции в виде объектов Map.Entry<K, V>
        for(Map.Entry<Integer, String> item : states.entrySet()) {
            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }

        Map<String, Person> people = new HashMap<String, Person>();
        people.put("1240i54", new Person("Tom"));
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for(Map.Entry<String, Person> item : people.entrySet()){
            //Обобщенный интерфейс Map.Entry<K, V> представляет объект с ключом типа K и значением типа V и определяет следующие методы:
            //boolean equals(Object obj): возвращает true, если объект obj, представляющий интерфейс Map.Entry, идентичен текущему
            //K getKey(): возвращает ключ объекта отображения
            //V getValue(): возвращает значение объекта отображения
            //V setValue(V v): устанавливает для текущего объекта значение v
            //int hashCode(): возвращает хеш-код данного объек
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
    }
}
