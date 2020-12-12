package PaternLearn.ShablonLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverage {

    //Переопределяем абстр методы, в уникальные для этого рецепта
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    //Определяем перехватчик для метода addCondiments
    public boolean customerWantsCondiments() {
        //Пишем метод для чтения данных из команд. строки
        String answer = getUserInput();
        //преобразует все символы в данной строки в нижний регистр
        //Проверяет начинается ли строка с указанного префикса с начала строки.
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;
        System.out.print("“Would you like milk and sugar with your coffee (y/n)? “");
        //Создаем поток из команд-строки в буфер
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            //Считываем строку из буфера в String
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("“IO error trying to read your answer”");
        }
        if (answer == null) {
            return "“no”";
        }
        return answer;
    }
}
