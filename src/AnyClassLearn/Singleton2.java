package AnyClassLearn;
// Существует другой вариант, когда вместо открытого статического поля создаётся открытый статический метод, а поле становится закрытым.
// Второй способ удобен тем, что вы можете позже отказаться от синглтона, но вам не придётся сильно переписывать код.
public class Singleton2 {

    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    public void someMethod() {
        System.out.println("\nTHis Singleton! I am a someMethod");
    }

    //Метод getInstance() является статическим, то есть методом КЛАССА.
    // При вызове статического метода необходимо указывать имя класса.
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}