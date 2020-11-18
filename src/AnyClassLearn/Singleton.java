package AnyClassLearn;

// Синглтон (singleton) это класс, у которого экземпляр создаётся только один раз
// Для реализации синглтона нужно создать закрытый конструктор и открытый статический член, который и позволяет получить доступ к единственному экземпляру класса.

public class Singleton {

    public static final Singleton INSTANCE = new Singleton();

    private Singleton(){}

    public void someMethod() {
        System.out.println("I am someMethod");
    }
    // Закрытый конструктор вызывается один раз для инициализации поля INSTANCE. Открытых конструктор у класса нет, поэтому после инициализации класса будет существовать только один экземпляр Single.
}


/* public class Singleton2 {

    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    public void someMethod() {
        System.out.println("I am a someMethod");
    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }
    // Существует другой вариант, когда вместо открытого статического поля создаётся открытый статический метод, а поле становится закрытым.
    // Второй способ удобен тем, что вы можете позже отказаться от синглтона, но вам не придётся сильно переписывать код.
} */