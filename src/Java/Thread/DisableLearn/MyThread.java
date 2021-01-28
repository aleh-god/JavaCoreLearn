package Java.Thread.DisableLearn;

class MyThread implements Runnable {

    private boolean isActive; //Распространенный способ завершения потока представляет опрос логической переменной.

    void disable(){
        isActive=false; // С помощью метода disable() мы можем сбросить состояние этой переменной.
    }

    MyThread(){
        isActive = true;
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){ //Переменная isActive указывает на активность потока.
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(400);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
