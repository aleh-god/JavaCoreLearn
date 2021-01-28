package Java.Thread.NewThread;
//Поскольку Runnable фактически представляет функциональный интерфейс, который определяет один метод, то объект этого интерфейса мы можем представить в виде лямбда-выражения:
public class AppRunnableLambda {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        Runnable r = ()->{
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        };
        Thread myThread = new Thread(r,"AppRunnableLambda");
        myThread.start();
        System.out.println("Main thread finished...");
    }
}
