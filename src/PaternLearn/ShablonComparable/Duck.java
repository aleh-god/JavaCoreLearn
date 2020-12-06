package PaternLearn.ShablonComparable;

//Итак, для сортировки объектов Duck необходимо реализовать метод compareTo(); тем самым вы предоставите классу Arrays информацию, необходимуую для завершения алгоритма сортировки.
//Класс должен реализовать интерфейс Comparable.
public class Duck implements Comparable {
    //Переменные экземпляров
    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    //Переопределяем метод для преобразования object -> String
    public String toString() {
        return name + " weighs " + weight;
    }

    //Метод необходим для сортировки шаблонного метода mergeSort() где compareTo() - перехватчик
    public int compareTo(Object object) {
        //Метод compareTo() получает другой объект Duck и сравнивает его с ТЕКУЩИМ объектом Duck.
        Duck otherDuck = (Duck)object;

        //Здесь определяется правило сравнения объектов Duck для шаблонного метода mergeSort()
        if (this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else { // this.weight > otherDuck.weight
            return 1;
        }
    }
}
