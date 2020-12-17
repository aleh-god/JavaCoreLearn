package InputOutputLearn.ObjectOIStream;

import java.io.*;
import java.util.ArrayList;
//Сериализация представляет процесс записи состояния объекта в поток, соответственно процесс извлечения или
//восстановления состояния объекта из потока называется десериализацией.
//Сразу надо сказать, что сериализовать можно только те объекты, которые реализуют интерфейс Serializable.
//Для сериализации объектов в поток используется класс ObjectOutputStream. Он записывает данные в поток.
public class main {
    public static void main(String[] args) {

        String filename = "people.dat";
        // создадим список объектов, которые будем записывать
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Tom", 30, 175, false));
        people.add(new Person("Sam", 33, 178, true));

        //Для создания объекта ObjectOutputStream в конструктор передается поток, в который производится запись:
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(people);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        // десериализация в новый список
        ArrayList<Person> newPeople= new ArrayList<Person>();
        //Класс ObjectInputStream отвечает за обратный процесс - чтение ранее сериализованных
        // данных из потока. В конструкторе он принимает ссылку на поток ввода:
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {

                        //Низведение к ArrayList
            newPeople=((ArrayList<Person>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        for(Person p : newPeople)
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
    }
}

class Person implements Serializable{
    // У каждого класса, реализующего Serializable, должно быть поле, содержащее уникальный идентификатор версии сериализованного класса, оно объявляется следующим образом:
    private static final long serialVersionUID = 1L;

    //По умолчанию сериализуются все переменные объекта.
    //Однако, возможно, мы хотим, чтобы некоторые поля были исключены из сериализации.
    //Для этого они должны быть объявлены с модификатором transient.
    private String name;
    private int age;
    private double height;
    private transient boolean married;

    Person(String n, int a, double h, boolean m){

        name=n;
        age=a;
        height=h;
        married=m;
    }
    String getName() {return name;}
    int getAge(){ return age;}
    double getHeight(){return height;}
    boolean getMarried(){return married;}
}