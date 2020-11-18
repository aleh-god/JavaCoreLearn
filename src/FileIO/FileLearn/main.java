package Java.FileLearn;

import java.io.File;
import java.io.IOException;
// Класс File, определенный в пакете java.io, не работает напрямую с потоками.
// Его задачей является управление информацией о файлах и каталогах.

public class main {
    public static void main(String[] args) {

        /* Для создания объектов класса File можно использовать один из следующих конструкторов.
        File(File dir, String name) - указывается объекта класса File (каталог) и имя файла
        File(String path) - указывается путь к файлу без указания имени файла
        File(URI uri) - указывается объекта URI, описывающий файл
         */
        File dir1 = new File("D://SomeDir");
        // создаем объекты для файлов, которые находятся в каталоге
        File file1 = new File("D://SomeDir", "Hello.txt");
        File file2 = new File(dir1, "Hello2.txt");

        String dirPath = "D:/";
        File dirList = new File(dirPath);
        // метод - получить список объектов
        String[] textDir = dirList.list();
        System.out.println("В каталоге: " + dirPath + " колличество объектов " + textDir.length);
        for (String text : textDir) System.out.println("Объект: " + text);

        // File(String dirPath, Sring name) - указывается путь к файлу и имя файла
        dirPath = "D:/Temp/Test/";
        File fileList = new File(dirPath, "Text test.txt");
        System.out.println("\n Методы работы с файлом.");
        System.out.println("Абсолютный путь файла: " + fileList.getAbsolutePath());
        System.out.println("файл существует или нет? " + fileList.exists());
        System.out.println("возвращает имя файла: " + fileList.getName());
        System.out.println("доступно для чтения? " + fileList.canRead());
        System.out.println("доступно для записи? " + fileList.canWrite());
        System.out.println("Путь к объекту: " + fileList.getPath());
        System.out.println("дата последнего изменения: " + fileList.lastModified());
        System.out.println("объект является файлом, а не каталогом: " + fileList.isFile());
        System.out.println("объект является каталогом: " + fileList.isDirectory());

        File newFile = new File("D:/Temp/Test/renameFile.txt");
        System.out.println("\nСоздаем новый файл.");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл существует или нет? " + newFile.exists());
        System.out.println("Новое имя файла: " + newFile.getName());
        System.out.println("Путь к новому объекту: " + newFile.getPath());

        // Переименовываем
        File newFileNext = new File("D:/Temp/Test/renameFileNext.txt");
        newFile.renameTo(newFileNext); // Поместить новый объект для переименовывания
        System.out.println("\nПереименовываем файл: " + newFile.exists());
        System.out.println("Новое имя файла: " + newFile.getName());
        System.out.println("Путь к переименованному объекту: " + newFile.getPath());

        newFile.delete(); //удаляет файл. Также можно удалить пустой каталог
        System.out.println("Удаляем файл. Файл живой? " + newFile.exists());

        // определяем объект для каталога
        File dir = new File("D:/SomeDir");
        boolean created = dir.mkdir();
        if(created)
            System.out.println("\nFolder has been created");
        System.out.println("объект является каталогом: " + dir.isDirectory());
        // переименуем каталог
        File newDir = new File("D:/newDir");
        dir.renameTo(newDir);
        System.out.println("переименуем каталог: " + newDir.getName());
        System.out.println("Полный адресс каталога: " + newDir.getAbsolutePath());
        // удалим каталог
        boolean deleted = newDir.delete();
        if(deleted)
            System.out.println("Folder has been deleted");

        // определяем объект для каталога
        File myFile = new File("D:/Temp/notes.txt");
        System.out.println("\nFile name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());
        if(myFile.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");

        System.out.println("File size: " + myFile.length());
        if(myFile.canRead())
            System.out.println("File can be read");
        else
            System.out.println("File can not be read");

        if(myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File can not be written");

        // создадим новый файл
        File newFile2 = new File("C://SomeDir//MyFile");
        try
        {
            boolean created2 = newFile2.createNewFile();
            if(created2)
                System.out.println("File has been created");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}