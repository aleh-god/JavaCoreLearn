package Java.Thread.WaitAndCondition;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Итак, у нас есть склад, где могут одновременно быть размещено не более 3 товаров.
 * И производитель должен произвести 5 товаров, а покупатель должен эти товары купить.
 * В то же время покупатель не может купить товар, если на складе нет никаких товаров:
 *
 * В том же примере со складом, покупателями и продавцами из статьи: в примере используется только 1 Condition, поэтому при достижении любого условия (склад пуст или склад полон) сигнал уходит всем - и продавцам и покупателям. Они все просыпаются, но в зависимости от состояния склада (product < 1 или product >= 3), одни из них тут же засыпают обратно, а другие идут дальше и выполняют нужную работу. Если же сделать 2 разных Condition, и чтобы методы put и get ждали на них, то тогда можно отправлять signal только нужным потокам (только ждущим в методе put или только ждущим в методе get), и не будить тех, кто все равно тут же снова уснет. Функционально это, конечно, ни на что не повлияет, но немного оптимизирует производительность.
 */

public class AppCondition {

    public static void main(String[] args) {

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;
    ReentrantLock locker;
    Condition condition;

    Store(){
        locker = new ReentrantLock(); // создаем блокировку
        condition = locker.newCondition(); // получаем условие, связанное с блокировкой
    }

    public void get() {

        locker.lock();
        try{
            // пока нет доступных товаров на складе, ожидаем
            // Как правило, сначала проверяется условие доступа. Если соблюдается условие, то поток ожидает, пока условие не изменится:
            while (product<1)
                condition.await(); // Поток ожидает, пока не будет выполнено некоторое условие и пока другой поток не вызовет методы signal/signalAll. Во многом аналогичен методу wait класса Object

            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            // сигнализируем
            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            /**
             * В блоке finally после всей окончания основной работы потока эта блокировка снимается.
             * Причем делается это обязательно в блоке finally, так как в случае возникновения ошибки все остальные потоки окажутся заблокированными.
             */
            locker.unlock();
        }
    }
    public void put() {

        locker.lock();
        try{
            // пока на складе 3 товара, ждем освобождения места
            // Как правило, сначала проверяется условие доступа. Если соблюдается условие, то поток ожидает, пока условие не изменится:
            while (product>=3)
                condition.await();

            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            // сигнализируем
            condition.signalAll();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock();
        }
    }
}
// класс Производитель
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
