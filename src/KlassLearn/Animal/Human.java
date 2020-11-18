package Java.Animal;

interface Human {
    // Интерфейс может иметь только переменные типа static final
    static final int hand = 2;
    static final int head = 1;

    // Методы интерфеса определяются позже
    public void takeEat();
    public void takeHome();
    public void takeHeal();
}
