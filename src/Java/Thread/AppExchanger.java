package Java.Thread;

import java.util.concurrent.Exchanger;

/**
 * Поток, вызывающий у обменника метод exchange() блокируется и ждет другой поток.
 * Когда другой поток вызовет тот же метод, произойдет обмен объектами: каждая из них получит аргумент другой в методе exchange().
 */

public class AppExchanger {

    public static void main(String[] args) {

        Exchanger<String> ex = new Exchanger<String>(); // типизируется типом данных, которыми потоки должны обмениваться.
        new Thread(new PutThread(ex)).start();
        new Thread(new GetThread(ex)).start();
    }
}

class PutThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> ex){

        this.exchanger=ex;
        message = "Hello Java!";
    }
    public void run(){

        try{
            // Обмен данными производится с помощью единственного метода этого класса exchange():
            message=exchanger.exchange(message); // Причем в ответ метод exchange возвращает данные, которые отправил в буфер другой поток.
            System.out.println("JavaThread has received: " + message);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
class GetThread implements Runnable{

    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger<String> ex){

        this.exchanger=ex;
        message = "Hello World!";
    }
    public void run(){

        try{
            message=exchanger.exchange(message);
            System.out.println("WorldThread has received: " + message); // Причем в ответ метод exchange возвращает данные, которые отправил в буфер другой поток.
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
