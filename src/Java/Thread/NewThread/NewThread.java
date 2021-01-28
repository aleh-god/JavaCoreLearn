package Java.Thread.NewThread;

/**
 * Для создания нового потока мы можем создать новый класс, либо наследуя его от класса Thread, либо реализуя в классе интерфейс Runnable.
**/
class NewThread extends Thread {

    NewThread(String name){
        super(name); // В конструктор своего класса потока мы можем передать различные данные, но главное, чтобы в нем вызывался конструктор базового класса Thread, в который передается имя потока.
    }

    public void run(){ //Также в классе переопределяется метод run(), код которого собственно и будет представлять весь тот код, который выполняется в потоке.

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted"); //Поток был прерван
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}
