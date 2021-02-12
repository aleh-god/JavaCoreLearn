package CollectionsAllLearn;

import java.util.Hashtable;

public class HashtableLearn {
    public static void main(String[] args) {

        /**
         * Старая коллекция, которая уже устарела.
         * Hashtable реализует интерфейс Map, которая хранит пары ключ-значения. Hashtable является синхронизированной и потокобезопасной коллекцией.
         * Hashtable не допускается null-ключей и дублирующих ключей, а также null-значений.
         */

        Hashtable<Integer, String> studentsHashtable = new Hashtable<Integer, String>();
        studentsHashtable.put(1, "Andrii");  // здесь все хорошо,
        studentsHashtable.put(2, null); // вылетит NullPointerException
    }
}
