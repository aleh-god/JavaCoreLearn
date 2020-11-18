package FileIO.FilePractice;
import java.io.File; // Класс, методы которого позволяют работать с файлами
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Нужно создать объект класса
        File x = new File("F:\\ProgFiles\\Import\\ImportText.txt");
        if (x.exists()) {       // Проверка на наличие файла
            System.out.println(x.getName() + " exist!");
        }
        else {
            System.out.println("The file does not exist");
        }
        // Чтение файла
        // класс Сканнер является наследником класса Итератор. Можно использовать все его методы.
        try {
            File read = new File("F:\\ProgFiles\\Import\\ImportText.txt");
            Scanner sc = new Scanner(read);
            while (sc.hasNext()) {
                System.out.print(sc.next());
                // Сканнер не считает пробел за элемент, а считает разделителем
                if (sc.hasNext()) {
                    System.out.print(" ");
                }
            }
            // Файл надо закрыть после использования.
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error read file");
        }
        // Создание файлов и запись в них содержимого объектов
        try {
            Formatter f = new Formatter("F:\\ProgFiles\\Export\\Java.test.txt");
            // %s - означает строку и заменяется параметром указанным левее, через запятые.
            // \r\n - символ новой строки в винде
            f.format("%s %s %s", "1", "Djon", "100$ \r\n");
            f.format("%s %s %s", "2", "Bob", "50$ \r\n");
            f.close();
        }
        catch (Exception e) {
            System.out.println("Error write file");
        }
    }
}
