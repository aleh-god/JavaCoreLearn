package InputOutputLearn.BufferedWriterReaderLearn;

import java.io.*;

//Класс BufferedWriter записывает текст в поток, предварительно буферизируя записываемые символы,
// тем самым снижая количество обращений к физическому носителю для записи данных.
public class main {
    public static void main(String[] agrs) {

        //В качестве параметра конструктор принимает поток вывода, в который надо осуществить запись. Второй параметр указывает на размер буфера.
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("notesLine.txt")))
        {
            String text = "String data:\nHey! Teachers! \nLeave them kids alone.\n";
            bw.write(text);
            text = "All in all it's just\nAnother brick in the wall\n";
            bw.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        //Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
        // Использование буфера призвано увеличить производительность чтения данных из потока.
        try(BufferedReader br = new BufferedReader(new FileReader("notesLine.txt")))
        {
            String s;
            /*
            Так как BufferedReader наследуется от класса Reader, то он может использовать все те методы для чтения из потока,
             которые определены в Reader. И также BufferedReader определяет свой собственный метод readLine(),
              который позволяет считывать из потока построчно.
             */
            while((s=br.readLine())!=null){
                System.out.println("Чтение построчно:");
                System.out.println(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
