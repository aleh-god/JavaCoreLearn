package Java.Thread.NewThread;

class MyThread implements Runnable { //Другой способ определения потока представляет реализация функционального интерфейса Runnable.

    public void run(){ //Этот интерфейс имеет один метод run: Здесь определяется весь тот код, который выполняется при запуске потока.

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

public class AppRunnable {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        /**
         * После определения объекта Runnable он передается в один из конструкторов класса Thread:
         * Thread(Runnable runnable, String threadName)
         */
        Thread myThread = new Thread(new MyThread(),"AppRunnable");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}
