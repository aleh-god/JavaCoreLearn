package ComparatorTest;

//Для того, чтобы объекты Person можно было сравнить и сортировать, они должны применять интерфейс Comparable<E>.
class Person implements Comparable<Person>{

    private String name;

    Person(String name){
        this.name = name;
    }

    String getName(){return name;}

    //Если этот метод возвращает отрицательное число, то текущий объект будет располагаться перед тем, который передается через параметр.
    // Если метод вернет положительное число, то, наоборот, после второго объекта.
    // Если метод возвратит ноль, значит, оба объекта равны.
    public int compareTo(Person p){
        //например, сравнивать по длине имени
        return name.length()-p.getName().length();
    }
}
