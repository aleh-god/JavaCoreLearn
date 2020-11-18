package AnyClassLearn;

// Создание собственного потока
public class MyThread extends Thread {
    // Конструктор
    MyThread() {
        // Создаём новый поток
        super("new thread");
        System.out.println("Создан новый поток: " + this);
        start(); // Запускаем поток
    }
    // Внутри метода run() вы размещаете код для нового потока. Этот поток завершится, когда метод вернёт управление.
    public void run() {
        System.out.println("Mой поток запущен!");
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Поток засыпает: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Второй поток прерван");
        }
    }

}
