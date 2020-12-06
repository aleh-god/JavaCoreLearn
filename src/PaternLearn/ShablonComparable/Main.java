package PaternLearn.ShablonComparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] agrs) {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2)
        };
        System.out.println("Before sorting:");
        display(ducks);
        //Вспомогательный метод sort() создает копию массива и передает ее вместе с приемным массивом методу mergeSort().
        //Метод mergeSort() содержит алгоритм сортировки, реализация которого зависит от метода compareTo().
        Arrays.sort(ducks);
        System.out.println("\nAfter sorting:");
        display(ducks);
    }
    public static void display(Duck[] ducks) {
        for (Duck d : ducks) {
            //Здесь используем наш переопределенный метод toString
            System.out.println(d);
        }
    }
}
