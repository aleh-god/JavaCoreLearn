package Java.FileStreamLearn;
// Класс FileOutputStream предназначен для записи байтов в файл.
// Он является производным от класса OutputStream, поэтому наследует всю его функциональность.

/*
Через конструктор класса FileOutputStream задается файл, в который производится запись. Класс поддерживает несколько конструкторов:
// Файл задается либо через строковый путь, либо через объект File.
FileOutputStream(String filePath)
FileOutputStream(File fileObj)
//  Второй параметр - append задает способ записи: eсли он равен true, то данные дозаписываются в конец файла, а при false - файл полностью перезаписывается
FileOutputStream(String filePath, boolean append)
FileOutputStream(File fileObj, boolean append)
 */

import java.io.*;

public class main {

    public static void main(String[] args) {

        String text = "Hello world!"; // строка для записи

        System.out.println("\nЗапись файлов и класс FileOutputStream");
        // Для создания объекта FileOutputStream используется конструктор,
        // принимающий в качестве параметра путь к файлу для записи.
        // Если такого файла нет, то он автоматически создается при записи.
        // Что бы исключить частые ошибки с файлами помещаем в блок try-catch + не надо закрывать поток в конце
        try(FileOutputStream fos = new FileOutputStream("F:/Prog files/Export/ExportText.txt"))
        {
            // перевод строки в байты
            //  Так как здесь записываем строку, то ее надо сначала перевести в массив байтов.
            // getBytes - кодирует данную строку в последовательность байтов
            byte[] buffer = text.getBytes();

            //  И с помощью метода write записывает в выходной поток массив байтов buffer
            fos.write(buffer, 0, buffer.length);
        }
        // Для автоматического закрытия файла и освобождения ресурса объект FileOutputStream создается с помощью конструктции try...catch.
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");

        System.out.println("\nЧтение файлов и класс FileInputStream");
        //
        try(FileInputStream fin = new FileInputStream("F:/Prog files/Import/ImportText.txt"))
        {
            // %d - это значение из fin.available() - возвращает количество байтов, доступных для чтения в потоке
            System.out.printf("File size: %d bytes \n", fin.available());

            // Когда в потоке больше нет данных для чтения, метод возвращает число -1.
            int i=-1;
            // В данном случае мы считываем каждый отдельный байт в переменную i:
            // int read(): возвращает целочисленное представление следующего байта в потоке. Когда в потоке не останется доступных для чтения байтов, данный метод возвратит число -1
            while((i=fin.read())!=-1){

                // Затем каждый считанный байт конвертируется в объект типа char и выводится на консоль.
                System.out.print((char)i);
            }
        }
        // Если файл не может быть открыт, например, по указанному пути такого файла не существует, то генерируется исключение FileNotFoundException.
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        // Подобным образом можно считать данные в массив байтов и затем производить с ним манипуляции:
        try(FileInputStream fin = new FileInputStream("F:/Prog files/Import/ImportText.txt"))
        {
            // размер буфера берем через метод available() - возвращает количество байтов, доступных для чтения в потоке
            byte[] buffer = new byte[fin.available()];
            // считаем файл в буфер
            // считывает некоторое количество байтов, равное length, из потока в массив buffer.
            // При этом считанные байты помещаются в массиве, начиная со смещения offset, то есть с элемента buffer[offset].
            // Метод возвращает число успешно прочитанных байтов.
            fin.read(buffer, 0, fin.available());

            System.out.println("\nFile data:");
            for(int i=0; i<buffer.length;i++){

            System.out.print((char)buffer[i]);
            }
        }
        // Если файл не может быть открыт, например, по указанному пути такого файла не существует, то генерируется исключение FileNotFoundException.
            catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("\nЧтение и запись через буфер.");
        // Конструкция "try-with-resources", которая автоматически освобождает ресурсы после успеха/неудачи.
        try(FileInputStream fin=new FileInputStream("F:/Prog files/Import/ImportText.txt");
            FileOutputStream fos=new FileOutputStream("F:/Prog files/Export/ExportText.txt"))
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        /*
    При завершении работы с потоком его надо закрыть с помощью метода close(), который определен в интерфейсе Closeable. Метод close имеет следующее определение:
    void close() throws IOException
    Этот интерфейс уже реализуется в классах InputStream и OutputStream, а через них и во всех классах потоков.
    При закрытии потока освобождаются все выделенные для него ресурсы, например, файл. В случае, если поток окажется не закрыт, может происходить утечка памяти.
         */
        System.out.println("\nЗакрытие потоков.");
        FileInputStream fin=null;
        try
        {
            fin = new FileInputStream("F:/Prog files/Import/ImportText.txt");
            int i=-1;
            while((i=fin.read())!=-1)
            {
                System.out.print((char)i);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        // чтобы быть уверенным, что поток в любом случае закроется, даже если при работе с ним возникнет ошибка,
        // вызов метода close() помещается в блок finally.
        finally
        {
            // И, так как метод close() также в случае ошибки может генерировать исключение IOException,
            // то его вызов также помещается во вложенный блок try..catch
            try
            {

                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }

        //Пример с использованием конструкции try-with-resources:
                                                        // В скобках можно несколько потоков открыть, через ;
        try(FileInputStream finTWR = new FileInputStream("F:/Prog files/Import/ImportText.txt"))
        {
            int i=-1;
            while((i=finTWR.read())!=-1)
            {

                System.out.print((char)i);
            }
        }
        // В этой конструкции не нужен финальный блок с закрытием потока. Автоматически.
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}