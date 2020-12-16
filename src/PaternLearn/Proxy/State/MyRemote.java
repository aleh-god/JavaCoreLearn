package PaternLearn.Proxy.State;

import java.rmi.Remote;
import java.rmi.RemoteException;
//Создание интерфейса удаленного доступа
                            //Означает, что интерфейс будет использоваться для поддержки удаленных вызовов.
public interface MyRemote extends Remote {
                            //Вызовы удаленных методов считаются «рискованными». Объявление RemoteException в каждом методе обращает внимание клиента на то, что вызов может не сработать.
          //Аргументы и возвращаемые значения должны быть примитивами или Serializable
    public String sayHello() throws RemoteException;
}
