package Java.Thread;

public class AppWaitNotify {

        public static void main(String[] args) {

            Store store=new Store();
            Producer producer = new Producer(store);
            Consumer consumer = new Consumer(store);
            new Thread(producer).start();
            new Thread(consumer).start();
        }
    }

/**
 * Почему используется связка - while + wait, а не if + wait?
 * в редких случаях тред может быть разбужен ложно, без вызова notify(), interrupt() или окончания таймаута,
 * поэтому следует перед продолжением выполнения еще раз проверить условие, по которому был вызван wait().
 */

// Класс Магазин, хранящий произведенные товары
    class Store{

        private int product=0;

        /**
         * с помощью wait() в методе get() мы ожидаем, когда производитель добавит новый продукт.
         * А после добавления вызываем notify(), как бы говоря, что на складе освободилось одно место, и можно еще добавлять.
         */
        public synchronized void get() { //wait() notify() методы вызываются только из синхронизированного контекста - синхронизированного блока или метода.
            while (product<1) { //Если условие истинно, то код цикла выполняется
                try {
                    wait(); // Освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()
                }
                catch (InterruptedException e) {
                }
            }

            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify(); //Продолжает работу потока, у которого ранее был вызван метод wait()
        }

        /**
         * А в методе put() с помощью wait() мы ожидаем освобождения места на складе.
         * После того, как место освободится, добавляем товар и через notify() уведомляем покупателя о том, что он может забирать товар.
         */
        public synchronized void put() { //wait() notify() методы вызываются только из синхронизированного контекста - синхронизированного блока или метода.
            while (product>=3) { //Если условие истинно, то код цикла выполняется
                try {
                    wait(); // Освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify()
                }
                catch (InterruptedException e) {
                }
            }

            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            notify(); //Продолжает работу потока, у которого ранее был вызван метод wait()
        }
    }

    // класс Производитель
    // Производитель в методе run() добавляет в объект Store с помощью его метода put() 6 товаров.
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
    // Потребитель в методе run() в цикле обращается к методу get объекта Store для получения этих товаров.
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
