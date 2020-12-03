package Operationable;

//При использовании конструкторов методы функциональных интерфейсов должны принимать тот же список параметров, что и конструкторы класса, и должны возвращать объект данного класса.
public class LambdaAppBuilder {

    public static void main(String[] args) {

        // Создаем ссылку на функц интерфейс и задаем тело метода :: -> new
                                //Тело метода ФИ
        UserBuilder userBuilder = User::new;
        // Создаем ссылку для объекта класса, а сам класс создаем через ссылку на ф-интерфейс, передавая туда String для конструктора
        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
    }
}
interface UserBuilder{
    //Пустой метод ФИ - сигнатура - вход и выход.
    User create(String name);
}

class User{

    private String name;

    User(String n){
        this.name=n;
    }

    String getName(){
        return name;
    }
}
