package StreamAPI;

import java.util.Comparator;
import java.util.stream.Stream;

public class AppSortedSteam {

    public static void main(String[] args) {

        // Создаем поток
        Stream<PhoneCompany> phoneStream = Stream.of(new PhoneCompany("iPhone X", "Apple", 600),
                new PhoneCompany("Pixel 2", "Google", 500),
                new PhoneCompany("iPhone 8", "Apple",450),
                new PhoneCompany("Nokia 9", "HMD Global",150),
                new PhoneCompany("Galaxy S9", "Samsung", 300));

                        // Создаем свой объект сортировки и помещаем в метод
        phoneStream.sorted(new PhoneComparator())
                .forEach(p->System.out.printf("%s (%s) - %d \n",
                        p.getName(), p.getCompany(), p.getPrice()));
    }
}

/**
 * Если же у нас классы объектов не реализуют этот интерфейс или мы хотим создать какую-то свою логику сортировки,
 * то мы можем использовать другую версию метода sorted(), которая в качестве параметра принимает компаратор.
 */

class PhoneComparator implements Comparator<PhoneCompany>{

    public int compare(PhoneCompany a, PhoneCompany b){
        // Приводим названия к одному регистру
        // В Java compareTo() получает значение 0, если аргумент является строкой лексически равной данной строке; значение меньше 0, если аргумент является строкой лексически большей, чем сравниваемая строка; и значение больше 0, если аргумент является строкой лексически меньшей этой строки.
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}

class PhoneCompany{

    private String name;
    private String company;
    private int price;

    public PhoneCompany(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }
}