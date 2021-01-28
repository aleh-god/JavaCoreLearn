package Java.Thread.DisableLearn;

public class AppActive {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MyThread myThread = new MyThread();
        //Для простого запуска потока не нужна переменная класса, можно начать сразу с new
        //После определения объекта Runnable он передается в один из конструкторов класса Thread:
        //Thread(Runnable runnable, String threadName)
        new Thread(myThread,"MyThread").start();

        //Если нужны манипуляции, нужна переменная
        //Thread t = new Thread(myThread,"MyThread");
        //t.start();

        //на 1100 миллисекунд останавливаем Main thread и потом вызываем метод myThread.disable(), который переключает в потоке флаг isActive. И дочерний поток завершается.
        try{
            Thread.sleep(1100);

            myThread.disable(); //С помощью метода disable() мы можем сбросить состояние переменной isActive и выполнение потока прервется - while(isActive)

            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
