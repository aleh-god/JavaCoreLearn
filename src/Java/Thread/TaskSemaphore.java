package Java.Thread;

import java.util.concurrent.Semaphore;

public class TaskSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        FreeResource freeRes = new FreeResource();
        new Thread(new Task(freeRes, semaphore, "CountThread 1")).start();
        new Thread(new Task(freeRes, semaphore, "CountThread 2")).start();
        new Thread(new Task(freeRes, semaphore, "CountThread 3")).start();
        new Thread(new Task(freeRes, semaphore, "CountThread 4")).start();

    }
}

class FreeResource {

    private Integer x = 0;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    synchronized public Integer increment() {
        return x++;}
}

class Task implements Runnable {

        FreeResource res;
        Semaphore sem;
        String name;

        Task(FreeResource res, Semaphore sem, String name){
            this.res=res;
            this.sem=sem;
            this.name=name;
        }

        public void run(){

            try{
                System.out.println(name + " ожидает разрешение и поставлен на паузу");
                sem.acquire();
                System.out.println(name + " Получает разрешение");
                for (int i = 1; i < 21; i++){
                    res.increment();
                    System.out.println(this.name + ": " + res.getX());
                    //Thread.sleep(100);
                }
            }
            catch(InterruptedException e){System.out.println(e.getMessage());}

            System.out.println(name + " освобождает разрешение");
            sem.release();
        }
    }
