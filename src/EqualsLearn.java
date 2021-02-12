import java.util.Objects;

public class EqualsLearn {
    public static void main(String[] args) {

    /**
            == tests for reference equality (whether they are the same object).
            Проверяет на равенство ссылки
            .equals() tests for value equality (whether they are logically "equal").
            Проверяет на равенство значение
    **/
        boolean myEquals;
        String t = "test";

        // These two have the same value
        myEquals = new String("test").equals("test"); // --> true
        System.out.println("new String(\"test\").equals(\"test\") // " + myEquals);

        // ... but they are not the same object
        myEquals = new String("test") == t; // --> false
        System.out.println("new String(\"test\") == \"test\" // " + myEquals);

        myEquals = new String("test") == new String("test"); // --> false
        System.out.println("new String(\"test\") == new String(\"test\") // " + myEquals);

        // ... but these are because literals are interned by the compiler and thus refer to the same object
        // Компилятор делает их одинаковыми объектами.
        // "test" == "test" // --> true
        // ... string literals are concatenated by the compiler and the results are interned.
        // Компилятор считает равными строки даже при суммировании частей "test" == "te" + "st" // --> true
        myEquals = ("test" == "te" + "st");
        System.out.println("\"test\" == \"te\" + \"st\" // " + myEquals);

        // ... but you should really just call Objects.equals()
        // Objects.equals() - сравнивает объекты по содержимому

        // You almost always want to use Objects.equals(). In the rare situation where you know you're dealing with interned strings, you can use ==
        // Moreover, a string literal always refers to the same instance of class String. This is because string literals - or, more generally, strings that are the values of constant expressions (§15.28) - are "interned" so as to share unique instances, using the method String.intern.
        myEquals = Objects.equals("test", new String("test")); // --> true
        System.out.println("Objects.equals(\"test\", new String(\"test\")) // " + myEquals);
        myEquals = Objects.equals(null, "test"); // --> false
        System.out.println("Objects.equals(null, \"test\") // " + myEquals);
        myEquals = Objects.equals(null, null); // --> true
        System.out.println("Objects.equals(null, null) // " + myEquals);

        // value equality that ignores case. Beware, however, that this method can have unexpected results in various locale-related cases, see this question.
        myEquals = new String("TEST").equalsIgnoreCase("test");
        System.out.println("new String(\"TEST\").equalsIgnoreCase(\"test\") // " + myEquals);

        // Метод contentEquals() — возвращает значение true только в том случае, если эта строка представляет собой ту же последовательность символов, которая указана в строке буфера (StringBuffer).
        StringBuffer sb = new StringBuffer("TEST");
        myEquals = new String("TEST").contentEquals(sb);
        System.out.println("new String(\"TEST\").contentEquals(new StringBuffer(\"TEST\")) // " + myEquals);

    }
}
