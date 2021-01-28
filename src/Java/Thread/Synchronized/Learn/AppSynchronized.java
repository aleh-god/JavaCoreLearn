package Java.Thread.Synchronized.Learn;

public class AppSynchronized {

    public static void main(String[] args) {

        //Создаем объект с общим ресурсом
        CommonResource commonResource= new CommonResource();

        for (int i = 1; i < 6; i++){
                                    //Создаем объект для потока, помещаем туда общий ресурс
            //Создаем объект потока, присваеваем переменной для взаимодействия
            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            //Запускаем поток
            t.start();
        }
    }
}

//Здесь определен класс CommonResource, который представляет общий ресурс и в котором определено одно целочисленное поле x.
class CommonResource{

    int x=0;
}

class CountThread implements Runnable{

    CommonResource res;

    CountThread(CommonResource res){
        this.res=res;
    }

    //Одним из способов синхронизации является использование ключевого слова synchronized. Этот оператор предваряет блок кода или метод, который подлежит синхронизации.
    public void run(){
        synchronized(res)
        { // После оператора synchronized идет объект-заглушка: synchronized(res). Причем в качестве объекта может использоваться только объект какого-нибудь класса, но не примитивного типа.
            res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }
}
