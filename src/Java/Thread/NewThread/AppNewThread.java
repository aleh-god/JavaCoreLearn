package Java.Thread.NewThread;

public class AppNewThread {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        /**
         * В методе main для запуска потока NewThread у него вызывается метод start(), после чего начинается выполнение того кода, который определен в методе run();
         */
        new NewThread("NewThread").start(); // Создаем объект-поток, передаем в конструктор имя, вызываем метод start:
        System.out.println("Main thread finished...");
    }
}
