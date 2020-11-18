package CollectionsAllLearn.StackLearn;
import java.util.Stack;
import java.util.*;

public class main {
    public static void main(String[] agrs) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Метод push() помещает объект в стек
        stack.push(1);
        stack.push(2);

        System.out.println("Текущий стек: " + stack);
        System.out.println("Удаляем: " + stack.pop()); // метод pop(), наоборот, вытаскивает объект из стека
        System.out.println("Удаляем: " + stack.pop());
        System.out.println("Удаляем: " + stack.pop());
        System.out.println("Текущий стек: " + stack);

        Cat barsik = new Cat("Барсик", 4);
        Cat murzik = new Cat("Мурзик", 6);
        Cat vaska = new Cat("Васька", 9);

        Stack<Cat> catStack = new Stack<>();
        catStack.push(barsik);
        catStack.push(murzik);
        catStack.push(vaska);

        System.out.println("Текущий стек: " + catStack);
        System.out.println("Брысь " + catStack.pop());
        System.out.println("Кто последний? " + catStack.peek().toString()); // Чтобы узнать, кто теперь последний в стеке, не удаляя его оттуда, нужно вызвать метод peek().
        System.out.println("Брысь " + catStack.pop());
        System.out.println("Кто последний? " + catStack.peek().toString());
        System.out.println("Брысь " + catStack.pop());
        System.out.println("Никого? " + catStack.empty()); // вызываем метод empty(), который возвращает булево значение.

        // Если при пустом стеке вызвать методы pop() или peek(), то программа закроется с ошибкой. Чтобы избежать подобной ситуации, нужно обработать исключение EmptyStackException.
        try {
            System.out.println("Кто последний? " + catStack.peek().toString());
        }catch (EmptyStackException e)
        {
            System.out.println("Пустой стек. Некого прогонять");
        }
        System.out.println("Текущий стек: " + catStack);
/* У класса также есть метод int search(Object o), который ищет заданный элемент в стеке, возвращая количество операций pop(),
 которые требуются для того чтобы перевести искомый элемент в вершину стека.
  Если заданный элемент в стеке отсутствует, этот метод возвращает -1.
 */
    }
}
