package Java.Thread.NewThread;

/**
 * При запуске потоков в примерах выше Main thread завершался до дочернего потока.
 * Как правило, более распространенной ситуацией является случай, когда Main thread завершается самым последним.
 * Для этого надо применить метод join(). В этом случае текущий поток будет ожидать завершения потока, для которого вызван метод join:
 * Если в программе используется несколько дочерних потоков, и надо, чтобы Main thread завершался после дочерних, то для каждого дочернего потока надо вызвать метод join.
 */

public class AppWaitEndThread {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        NewThread t = new NewThread("AppWaitEndThread ");
        t.start();
        try{
            t.join(); //Тот кто вызвал метод join для объекта-потока - ждет завершение этого потока (здесь main)
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }
}
