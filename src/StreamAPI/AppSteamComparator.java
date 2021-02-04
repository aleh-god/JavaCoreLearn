package StreamAPI;

import java.util.stream.Stream;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Интерфейс Comparator - это функциональный интерфейс, который определяет один метод compare, принимающий два сравниваемых объекта и возвращающий число
 * (если первый объект больше, возвращается положительное число, иначе возвращается отрицательное число).
 * Поэтому вместо конкретной реализации компаратора мы можем передать лямбда-вырашение или метод, который соответствует методу compare интерфейса Comparator.
 * Поскольку сравниваются числа, то в метод передается в качестве компаратора статический метод Integer.compare().
 */

public class AppSteamComparator {
    public static void main(String[] args) {

        ArrayList<Phonecompare> phones = new ArrayList<Phonecompare>();
        phones.addAll(Arrays.asList(new Phonecompare[]{
                new Phonecompare("iPhone 8", 52000),
                new Phonecompare("Nokia 9", 35000),
                new Phonecompare("Samsung Galaxy S9", 48000),
                new Phonecompare("HTC U12", 36000)
        }));

        // вместо конкретной реализации компаратора мы можем передать лямбда-вырашение или метод, который соответствует методу compare интерфейса Comparator.
        Phonecompare min = phones.stream().min(Phonecompare::compare).get(); // из Optional, необходимо вызвать метод get()
        Phonecompare max = phones.stream().max(Phonecompare::compare).get(); // из Optional, необходимо вызвать метод get()
        System.out.printf("MIN Name: %s Price: %d \n", min.getName(), min.getPrice());
        System.out.printf("MAX Name: %s Price: %d \n", max.getName(), max.getPrice());
    }
}
class Phonecompare{

    private String name;
    private int price;

    public Phonecompare(String name, int price){
        this.name=name;
        this.price=price;
    }

    /**
     * В данном случае мы находим минимальный и максимальный объект Phone: фактически объекты с максимальной и минимальной ценой.
     * Для определения функциональности сравнения в классе Phone реализован статический метод compare, который соответствует сигнатуре метода compare интерфейса Comparator.
     * И в методах min и max применяем этот статический метод для сравнения объектов.
     */
    // вместо конкретной реализации компаратора мы можем передать лямбда-вырашение или метод, который соответствует методу compare интерфейса Comparator.
    public static int compare (Phonecompare p1, Phonecompare p2){
        if(p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }

    public String getName() { return name; }
    public int getPrice() { return price;}
}
