package AnyClassLearn;

public class getClass {
    // Иногда из программы нужно получить имя используемого класса. Для этого есть специальные методы getClass().getName()
    // Метод getSuperclass() возвращает имя суперкласса.
    /* public void onClick(this name); {
        String className = this.getClass().getName();
        String simpleName = this.getClass().getSimpleName(); //getSimpleName() возвращает только имя класса без пакета, другие методы вернут полное название.
        String canonicalName = this.getClass().getCanonicalName();

        if (canonicalName == null) {
            canonicalName = "null";
        }

        String s = "Имя класса: " + className + "\n" + "SimpleName: " + simpleName + "\n" + "CanonicalName: " + canonicalName + "\n";
        System.out.println(s);
    }
    /* Если нужно узнать имя класса активности, то достаточно кода:
                         подставьте имя вашей активности
        String className = MainActivity.class.getName();

    Если вам известно имя класса, то можете получить сам класс:

    try {
        // получим объект Class
        Class<?> myClass = Class.forName("ru.alexanderklimov.test.MainActivity");
        mInfoTextView.setText(myClass.getName()); // выводим в TextView

        Intent intent = new Intent(this, myClass);
        startActivity(intent);
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    Метод getSuperclass() возвращает имя суперкласса.  */
}
