package Java.TextFileLearn;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class main {
    public static void main(String[] agrs) {

        System.out.println("Класс FileWriter.");
        //Класс FileWriter является производным от класса Writer. Он используется для записи текстовых файлов.
        //Параметр append указывает, должны ли данные дозаписываться в конец файла (если параметр равен true), либо файл должен перезаписываться.
        try(FileWriter writer = new FileWriter("notesFileWR.txt", false))
        {
            // запись всей строки
            String text = "Это запись с помощью класса FileWriter.";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');
            writer.append('n');
            writer.append('d');
            // Когда идет запись, то данные сначала сохраняются в буфере, а потом записываются в файл.
            // Чтобы быть уверенным, что буфер будет очищен, а все его данные запишутся в файл, вызывается метод flush
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("\nКласс FileReader.");
        //Класс FileReader предоставляет функциональность для чтения текстовых файлов.
        try(FileReader reader = new FileReader("notesFileWR.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("\nЧитаем в промежуточный буфер.");
        //Также мы можем считывать в промежуточный буфер из массива символов
        try(FileReader reader = new FileReader("notes256.txt"))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);

                }
                System.out.println("\nБуфер ");
                System.out.print(buf);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}