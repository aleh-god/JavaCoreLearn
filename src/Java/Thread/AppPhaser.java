package Java.Thread;

import java.util.concurrent.Phaser;

/**
 * При работае с классом Phaser обычно сначала создается его объект. Далее нам надо зарегистрировать все участвующие стороны.
 * Для регистрации в каждой стороне вызывается метод register(), либо можно обойтись и без этого метода, передав нужное количество сторон в конструктор Phaser.
 * Затем каждая сторона выполняет некоторый набор действий, составляющих фазу. А синхронизатор Phaser ждет, пока все стороны не завершат выполнение фазы.
 * Чтобы сообщить синхронизатору, что фаза завершена, сторона должна вызвать метод arrive() или arriveAndAwaitAdvance().
 * После этого синхронизатор переходит к следующей фазе.
 */

public class AppPhaser {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1); // Параметр parties указывает на количество сторон (потоков), которые должны выполнять все фазы действия.
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // Синхронизатор Phaser ждет, пока все стороны не завершат выполнение фазы 0
        int phase = phaser.getPhase(); // Возвращает номер текущей фазы
        phaser.arriveAndAwaitAdvance(); // Чтобы сообщить синхронизатору, что фаза завершена, сторона должна вызвать метод arrive() или arriveAndAwaitAdvance(). После этого синхронизатор переходит к следующей фазе.
        System.out.println("Фаза " + phase + " завершена");
        // Синхронизатор Phaser ждет, пока все стороны не завершат выполнение фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // Синхронизатор Phaser ждет, пока все стороны не завершат выполнение фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister(); // сообщает о завершении всех фаз стороной и снимает ее с регистрации. Возвращает номер текущей фазы или отрицательное число, если синхронизатор Phaser завершил свою работу
    }
}

class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }

    public void run(){

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        try{
            Thread.sleep(200); // Для красивого вывода в консоль.
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }
}
