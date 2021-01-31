package Java.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Вначале поток пытается получить доступ к общему ресурсу. Если он свободен, то на него накладывает блокировку.
 * После завершения работы блокировка с общего ресурса снимается. Если же ресурс не свободен и на него уже наложена блокировка, то поток ожидает, пока эта блокировка не будет снята.
 */

public class AppLock {

    public static void main(String[] args) {

        LockResource lockResource= new LockResource();
        ReentrantLock locker = new ReentrantLock(); // Классы блокировок реализуют интерфейс Lock. создаем заглушку

        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new LockThread(lockResource, locker));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

class LockResource{

    int x=0;
}

class LockThread implements Runnable{

    LockResource res;
    ReentrantLock locker;

    LockThread(LockResource res, ReentrantLock lock){
        this.res=res;
        locker = lock;
    }

    public void run(){

        locker.lock(); // На входе в критическую секцию устанавливается заглушка: устанавливаем блокировку

        // После этого только один поток имеет доступ к критической секции, а остальные потоки ожидают снятия блокировки.
        try{
            res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            /**
             * В блоке finally после всей окончания основной работы потока эта блокировка снимается.
             * Причем делается это обязательно в блоке finally, так как в случае возникновения ошибки все остальные потоки окажутся заблокированными.
             */
            locker.unlock(); // снимаем блокировку
        }
    }
}
