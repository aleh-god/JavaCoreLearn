package InputOutputLearn.DataStreamLearn;

//Классы DataOutputStream и DataInputStream позволяют записывать и считывать данные примитивных типов,
//таких, как int, double и т.д. Для записи и чтения каждого из примитивных типов предназначен свой метод.

import java.io.*;

public class main {
    public static void main(String[] agrs) {
        Person tom = new Person("Tom", 34, 1.68, false);
        // запись в файл
        // Объект принимает данные на выходной поток примитивов -> в выходной поток в файл -> в указанный файл
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin")))
        {
            // записываем значения примитивов, для каждого свой метод
            dos.writeUTF(tom.name);
            dos.writeInt(tom.age);
            dos.writeDouble(tom.height);
            dos.writeBoolean(tom.married);
            System.out.println("File has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        // обратное считывание из файла
        // Объект принимает входной поток примитивов <- из входного потока файлов <- из указанного файла
        try(DataInputStream dos = new DataInputStream(new FileInputStream("data.bin")))
        {
            // записываем значения
            String name = dos.readUTF();
            int age = dos.readInt();
            double height = dos.readDouble();
            boolean married = dos.readBoolean();
            System.out.printf("Name: %s  Age: %d  Height: %f  Married: %b",
                    name, age, height, married);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

class Person
{
    public String name;
    public int age;
    public double height;
    public boolean married;

    public Person(String n, int a, double h, boolean m)
    {
        this.name=n;
        this.height=h;
        this.age=a;
        this.married=m;
    }
}
