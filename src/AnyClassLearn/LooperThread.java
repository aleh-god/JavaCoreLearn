package AnyClassLearn;

// Поток имеет в своём составе сущности Looper, Handler, MessageQueue.
// Каждый поток имеет один уникальный Looper и может иметь много Handler.
// Считайте Looper вспомогательным объектом потока, который управляет им. Он обрабатывает входящие сообщения, а также даёт указание потоку завершиться в нужный момент.
// Поток получает свой Looper и MessageQueue через метод Looper.prepare() после запуска. Looper.prepare() идентифицирует вызывающий потк, создаёт Looper и MessageQueue и связывает поток с ними в хранилище ThreadLocal. Метод Looper.loop() следует вызывать для запуска Looper. Завершить его работу можно через метод looper.quit().
//
/*
class LooperThread extends Thread {
    public Handler mHandler;

    public void run() {
        Looper.prepare();

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                // process incoming messages here
            }
        };
        Looper.loop();
    }
}
*/