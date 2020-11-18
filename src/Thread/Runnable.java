package Java.Thread;

// Запуск потока через интерфейс. Объект интерфеса помещаем в коструктор класса Thread, при вызове этого конструктора.
class RunnableX implements Runnable {
    public void run() {
     System.out.println("Hello interface!");
 }
}
