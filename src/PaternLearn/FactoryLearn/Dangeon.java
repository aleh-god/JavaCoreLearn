package PaternLearn.FactoryLearn;

public abstract class Dangeon {

    // Стандартная инструкция создания героя - неизменна для остальных субклассов
    public Heroes orderHeroes(String type) {
        //Ссылка на общий супер-класс
        Heroes heroes;
        // Запускаем метод выбора героя по параметру
        heroes = choiseHeroes(type);
        // Запускаем стандартные методы или перегруженные в зависимости от
        heroes.prepare();
        heroes.travel();
        heroes.fight();
        heroes.sleep();
        return heroes;
    }

    // Выбор героев через ветвление отдает на откуп перегруженным методам в созданных субклассах
    protected abstract Heroes choiseHeroes(String type);
}