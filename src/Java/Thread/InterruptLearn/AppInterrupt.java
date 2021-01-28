package Java.Thread.InterruptLearn;

/**
 * Еще один способ вызова завершения или прерывания потока представляет метод interrupt(). Вызов этого метода устанавливает у потока статус, что он прерван.
 * Сам метод возвращает true, если поток может быть прерван, в ином случае возвращается false.
 * При этом сам вызов этого метода НЕ завершает поток, он только устанавливает статус: в частности,
 * метод isInterrupted() класса Thread будет возвращать значение true. Мы можем проверить значение возвращаемое данным методом и прозвести некоторые действия.
 */

class JThread extends Thread {

    JThread(String name){
        super(name); //обязательное делегирование к super
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов

        // Мы можем получить статус текущего потока с помощью метода isInterrupted(). И пока этот метод возвращает false, мы можем выполнять цикл.
        // А после того, как будет вызван метод interrupt, isInterrupted() возвратит true, и соответственно произойдет выход из цикла.
        while(!isInterrupted()){

            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
public class AppInterrupt {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        JThread t = new JThread("JThread");
        t.start();
        try{
            Thread.sleep(150);
            t.interrupt();

            Thread.sleep(150);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
