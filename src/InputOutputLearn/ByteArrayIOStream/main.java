package Java.ByteArrayIOStream;
/*
Класс ByteArrayInputStream представляет входной поток, использующий в качестве источника данных массив байтов.
Он имеет следующие конструкторы:
ByteArrayInputStream(byte[] buf)
ByteArrayInputStream(byte[] buf, int offset, int length)
В качестве параметров конструкторы используют массив байтов buf, из которого производится считывание,
смещение относительно начала массива offset и количество считываемых символов length.
 */

import java.io.*;

public class main
{
    public static void main(String[] agrs)
    {
        System.out.println("\nЧтение массива байтов и класс ByteArrayInputStream");
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while((b=byteStream1.read())!=-1){

            System.out.print(b);
        }

        System.out.print("\n");
        String text = "Hello Input!";
        // Переводим из строки в набор байтов
        byte[] array2 = text.getBytes();
        // считываем 5 символов
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
        int c;
        while((c=byteStream2.read())!=-1){

            System.out.print((char)c);
        // В отличие от других классов потоков для закрытия объекта ByteArrayInputStream не требуется вызывать метод close.
        }

        System.out.println("\nЗапись массива байт и класс ByteArrayOutputStream");
        /*
Класс ByteArrayOutputStream представляет поток вывода, использующий массив байтов в качестве места вывода.
Чтобы создать объект данного класса, мы можем использовать один из его конструкторов:
ByteArrayOutputStream() - размер 32 байта
ByteArrayOutputStream(int size)
         */
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        text = "Hello Output!";
        byte[] buffer = text.getBytes();

        //Так как метод write может сгенерировать исключение, то вызов этого метода помещается в блок try..catch.
        try{
            //метод write, который записывает в поток некоторые данные. В данном случае мы записываем в поток массив байтов.
            // Этот массив байтов записывается в объекте ByteArrayOutputStream в защищенное поле buf,
            // которое представляет также массив байтов (protected byte[] buf).
            baos.write(buffer);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        // превращаем массив байтов в строку
        // Используя методы toString() и toByteArray(),
        // можно получить массив байтов buf в виде текста или непосредственно в виде массива байт.
        System.out.println(baos.toString());

        // получаем массив байтов и выводим по символьно
        byte[] array = baos.toByteArray();
        for(byte bb: array){

            System.out.print((char)bb);
        }
        System.out.println();

        // С помощью метода writeTo мы можем вывести массив байт в другой поток.
        // Данный метод в качестве параметра принимает объект OutputStream
        try(FileOutputStream fos = new FileOutputStream("F:/Prog files/Export/ByteArrayOutputStream.txt")){

            baos.writeTo(fos);
        }
        catch(IOException e){

            System.out.println(e.getMessage());
        }

        System.out.println("\nКласс BufferedInputStream");
        //создает буфер для потоков ввода. Этот буфер накапливает вводимые байты без постоянного обращения к устройству.
        //И когда буфер заполнен, производится запись данных.

        text = "Hello BufferedInput!";
        // массив байтов определили уже выше
        buffer = text.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        try(BufferedInputStream bis = new BufferedInputStream(in)){

            int cc;
            while((cc=bis.read())!=-1){

                System.out.print((char)cc);
            }
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }

        System.out.println("\nКласс BufferedOutputStream");
        //Класс не добавляет новой функциональности, он просто оптимизирует действие потока вывода.

        text = "Hello BufferedOutput!"; // строка для записи
        try(FileOutputStream out=new FileOutputStream("F:/Prog files/Export/BufferedOutputStream.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out))
        {
            // перевод строки в байты
            buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}