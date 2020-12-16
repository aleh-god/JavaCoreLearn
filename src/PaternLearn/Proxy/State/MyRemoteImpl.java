package PaternLearn.Proxy.State;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//создание реализации интерфейса удаленного доступа
                          //Для работы в качестве удаленной службы ваш объект должен обладать некоторой стандартной функциональностью. Для включения этой функциональности проще всего расширить класс UnicastRemoteObject
                                                    //Служба должна реализовать интерфейс удаленного доступа — интерфейс, методы которого будут вызываться клиентом.
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

                            //UnicastRemoteObject реализует интерфейс Serializable, поэтому понадобится поле serialVersionUID.
    private static final long serialVersionUID = 1L;

    //У нового суперкласса UnicastRemoteObject имеется одна проблема — его конструктор может инициировать исключение RemoteException.
    //Единственное решение заключается в объявлении конструктора вашей удаленной реализации, чтобы у вас появилось место для объявления RemoteException.
    public MyRemoteImpl() throws RemoteException { } //Это всего лишь способ объявить, что конструктор суперкласса инициирует исключение.

    //Чтобы созданная служба стала доступной для удаленных клиентов, следует создать ее экземпляр и поместить его в реестр RMI (который должен работать в системе; в противном случае выполнение этой строки кода завершится неудачей).
    // При регистрации объекта реализации система RMI помещает в реестр заглушку, потому что клиент взаимодействует именно с ней.
    // Регистрация службы осуществляется статическим методом rebind()
    public static void main (String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //все методы интерфейса должны быть реализованы, но объявлять RemoteException НЕ ОБЯЗАТЕЛЬНО.
    public String sayHello() {
        return "Server says, ‘Hey’";
    }
// more code in class
}
