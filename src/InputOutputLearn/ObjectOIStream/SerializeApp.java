package InputOutputLearn.ObjectOIStream;

import java.io.*;
import java.util.ArrayList;
//Сериализация представляет процесс записи состояния объекта в поток, соответственно процесс извлечения или
//восстановления состояния объекта из потока называется десериализацией.
//Сразу надо сказать, что сериализовать можно только те объекты, которые реализуют интерфейс Serializable.
//Для сериализации объектов в поток используется класс ObjectOutputStream. Он записывает данные в поток.
public class SerializeApp {
    public static void main(String[] args) {

        // Java при сериализации объекта в файл установленным архитектурным требованием Java является присвоение файлу расширения .ser
        String filename = "people.ser";
        // создадим список объектов, которые будем записывать
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Tom", 30, 175, false));
        people.add(new Person("Sam", 33, 178, true));

        //Для создания объекта ObjectOutputStream в конструктор передается поток, в который производится запись:
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(people);
            System.out.println("File has been written.");
        }
        // public final void writeObject(Object x) throws IOException
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
        // Блок попытка-перехват пытается перехватить исключение ClassNotFoundException (класс не найден исключение), описываемый методом readObject() (чтение Объекта()).
        // Чтобы JVM могла провести десериализацию объекта, она должна найти байт-код для класса.
        // Если JVM не может найти класс во время выполнения десериализации объекта, она генерирует исключение ClassNotFoundException.
        // public final Object readObject() throws IOException, ClassNotFoundException
        catch (IOException i) {
            i.printStackTrace();
            return;}
        catch (ClassNotFoundException c) {
        System.out.println("Класс Employee не найден");
        c.printStackTrace();
        return;
        }

        for(Person p : newPeople)
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
    }
}

class Person implements Serializable{ // Класс должен реализовывать интерфейс java.io.Serializable.

    // У каждого класса, реализующего Serializable, должно быть поле, содержащее уникальный идентификатор версии сериализованного класса, оно объявляется следующим образом:
    private static final long serialVersionUID = 1L;

    //По умолчанию сериализуются все переменные объекта.
    //Однако, возможно, мы хотим, чтобы некоторые поля были исключены из сериализации.
    //Для этого они должны быть объявлены с модификатором transient.
    private String name;
    private int age;
    private double height;
    private transient boolean married; // исключен из сериализации

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