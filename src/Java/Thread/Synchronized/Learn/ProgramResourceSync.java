package Java.Thread.Synchronized.Learn;

public class ProgramResourceSync {

    public static void main(String[] args) {

        CommonResourceSync commonResourceSync= new CommonResourceSync();

        for (int i = 1; i < 6; i++){
            Thread t = new Thread(new CountThreadSync(commonResourceSync));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}

//Синхронизацию можно перенести в класс рессурс и освободить классы с основным кодом
class CommonResourceSync{

    int x;

    //При применении оператора synchronized к методу пока этот метод не завершит выполнение, монопольный доступ имеет только один поток - первый, который начал его выполнение.
    synchronized void increment(){ // Метод сихронизирован специальным параметром
        x=1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}

class CountThreadSync implements Runnable{

    CommonResourceSync res;
    CountThreadSync(CommonResourceSync res){
        this.res=res;
    }

    public void run(){
        res.increment(); // Здесь остался только метод синхронизации.
    }
}
