package RecursionLearn;

// Рекурсия в программировании - это когда метод вызывает сам себя. В таком случае метод называют рекурсивным.
// Факториал числа N - это произведение всех целых чисел от 1 до N.

public class Factorial {
    // рекурсивный метод
    int fact(int n) {
        int result; // Здесь нельзя ничего присваивать, только заявлять.

        if (n == 1) {
            System.out.println("Глубина стека = 1. Подымаемся на поверхность.");
            return 1;
        }
        /* При использовании рекурсивных методов нужно смотреть, чтобы в программе был оператор if для выхода из рекурсивного метода без выполнения рекурсивного вызова.
         Иначе метод никогда не выполнит возврат.          */

        /* Когда метод вызывает сам себя, новым локальным переменным и параметром выделяется место в стеке и код метода выполняется с этими новыми начальными значениями.
         При каждом возврате из рекурсивного вызова старые локальные переменные и параметры удаляются из стека, и выполнение продолжается с момента вызова внутри метода.
         */
        System.out.println("Глубина стека: " + n);
        // System.out.println("Промежуточный результат: " + result); Здесь выдает ошибку. Промежуточный результат = null
        result = fact(n - 1) * n;
        System.out.println("Промежуточный результат: " + result);
        return result;
    }
}