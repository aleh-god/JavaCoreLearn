package Java.Thread;
/**
 * Для управления доступом к ресурсу семафор использует счетчик, представляющий количество разрешений.
 * Если значение счетчика больше нуля, то поток получает доступ к ресурсу, при этом счетчик уменьшается на единицу.
 * После окончания работы с ресурсом поток освобождает семафор, и счетчик увеличивается на единицу.
 * Если же счетчик равен нулю, то поток блокируется и ждет, пока не получит разрешение от семафора.
 */

import java.util.concurrent.Semaphore;

public class AppSemaphore {

    public static void main(String[] args) {

        // Установить количество разрешений для доступа к ресурсу можно с помощью конструкторов класса Semaphore:
        Semaphore sem = new Semaphore(1); // 1 разрешение
        CommonResource res = new CommonResource();

                                 // В потоки можно передавать различные параметры и объекты
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();
    }
}
class CommonResource{

    int x=0;
}

class CountThread implements Runnable{

    CommonResource res;
    Semaphore sem;
    String name;

    CountThread(CommonResource res, Semaphore sem, String name){
        // В потоки можно передавать различные параметры и объекты
        this.res=res;
        this.sem=sem;
        this.name=name;
    }

    public void run(){

        try{
            System.out.println(name + " ожидает разрешение");
            sem.acquire(); // Для получения разрешения у семафора надо вызвать метод acquire()
            //res.x=1;
            for (int i = 1; i < 5; i++){
                res.x++;
                System.out.println(this.name + ": " + res.x);
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}

        System.out.println(name + " освобождает разрешение");
        sem.release(); // После окончания работы с ресурсом полученное ранее разрешение надо освободить с помощью метода release():
    }
}
