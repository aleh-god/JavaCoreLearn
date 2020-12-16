package PaternLearn.Proxy.State;
import java.rmi.*;

//Клиент должен получить объект заглушки (заместителя), поскольку именно его методы будут вызываться клиентом. За этой информацией он обращается к реестру RMI.
// Клиент указывает имя и запрашивает заглушку, зарегистрированную с этим именем.
public class MyRemoteClient {
    public static void main (String[] args) {
        new MyRemoteClient().go();
    }
    public void go() {
        try {
                                                            //Имя или IP-адрес хоста, на котором работает служба.
                                //Необходимо преобразование к типу интерфейса, поскольку по запросу возвращается тип Object.
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            //Выглядит как обычный вызов метода! (кроме подтверждения возможности RemoteException).
            String s = service.sayHello();
            System.out.println(s);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
