package InputOutputLearn.PrintWriteStream;
/*
Форматируемый ввод и вывод!
Класс PrintStream - это именно тот класс, который используется для вывода на консоль.

Мы можем использовать данный класс для записи информации в поток вывода.
Для этого PrintStream определяет ряд конструкторов:
PrintStream(OutputStream outputStream)
PrintStream(OutputStream outputStream, boolean autoFlushingOn)
PrintStream(OutputStream outputStream, boolean autoFlushingOn, String charSet) throws UnsupportedEncodingException
PrintStream(File outputFile) throws FileNotFoundException
PrintStream(File outputFile, String charSet) throws FileNotFoundException, UnsupportedEncodingException
PrintStream(String outputFileName) throws FileNotFoundException
PrintStream(String outputFileName, String charSet) throws FileNotFoundException, UnsupportedEncodingException

Параметр outputStream - это объект OutputStream, в который производится запись.
Параметр autoFlushingOn при значении true позволяет автоматически записывать данные в поток вывода.
По умолчанию этот параметр равен false. Параметр charSet позволяет указать кодировку символов.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class main {
    public static void main(String[] agrs) {
        System.out.println("\nКласс PrintStream.");
        String text = "Запишем информацию в файл!"; // строка для записи
        try(FileOutputStream fos = new FileOutputStream("F:/Prog files/Export/FileOutputStream.txt");
            PrintStream printStream = new PrintStream(fos))
        {
            //В качестве потока вывода используется объект FileOutputStream.
            //С помощью метода println() производится запись информации в выходной поток - то есть в объект FileOutputStream.
            printStream.println(text);
            System.out.println("Запись в файл произведена");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("\nМетод Write класса PrintStream.");
        try(PrintStream printStream = new PrintStream("F:/Prog files/Export/PrintStream.txt"))
        {
            printStream.print("Hello World!");
            printStream.println("Welcome to Java!");

            printStream.printf("Name: %s Age: %d \n", "Tom", 34);

            String message = "Text to Bytes to printStream.";
            byte[] message_toBytes = message.getBytes();
            printStream.write(message_toBytes);

            System.out.println("The file has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        //PrintWriter реализует интерфейсы Appendable, Closable и Flushable, и поэтому после использования представляемый им поток надо закрывать.
        //Для записи данных в поток он также используется методы printf() и println().
        System.out.println("\nВывод на консоль");
        try(PrintWriter pw = new PrintWriter(System.out))
        {
            pw.println("Hello console.");
        }
    }
}
