package Java.Thread;

class MyClass {
    public static void main (String[ ] agrs) {
        Loader obj = new Loader();
        // Метод start запускает метод run в потоке
        obj.start();
        // Устанавливаем приоритет исполнения. По умолчанию - 5
        obj.setPriority(6);

        // Создаем объект, где класс, от интерфейса, передаем в конструктор
        Thread t = new Thread(new RunnableX());
        t.start();
        try {
            t.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}