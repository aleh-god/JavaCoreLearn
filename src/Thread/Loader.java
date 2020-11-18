package Java.Thread;

class Loader extends Thread {
    // Наследуем класс и переопределяем поток run, наполняя его функциональностью потока.
    public void run() {
        System.out.println("Hello thread!");
    }
}
// Объект можно запустить командой start.
