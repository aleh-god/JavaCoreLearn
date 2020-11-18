package Java;

import java.util.Scanner;

public class ExceptionLearn {
    public static void main(String[] agrs) {
        // конструкция try...catch...finally.
        // При возникновении исключения в блоке try управление переходит в блок catch, который может обработать данное исключение.
        // Если такого блока не найдено, то пользователю отображается сообщение о необработанном исключении, а дальнейшее выполнение программы останавливается.
        try {
            int[] numbers = new int[3];
            //программа остановится и перейдет к блоку catch
            numbers[4] = 45;
            System.out.println(numbers[4]);
            // Выражение catch имеет следующий синтаксис: catch (тип_исключения имя_переменной).
            // В данном случае объявляется переменная ex, которая имеет тип Exception.
        } catch (Exception ex) {
            // вывод на консоль стека трассировки ошибки с помощью метода printStackTrace(), определенного в классе Exception
            ex.printStackTrace();
        }
        // Блок finally выполняется в любом случае, возникло ли исключение в блоке try или нет
        finally {
            System.out.println("Блок finally");
        }
        // После завершения выполнения блока catch программа продолжает свою работу, выполняя все остальные инструкции после блока catch.
        System.out.println("Программа завершена");

        // Обработка нескольких исключений, включив дополнительные блоки catch:
        int[] numbers = new int[3];
        try {
            numbers[6] = 45;
            numbers[6] = Integer.parseInt("gfd");
        } catch (ArrayIndexOutOfBoundsException ex) {

            System.out.println("Выход за пределы массива");
        } catch (NumberFormatException ex) {

            System.out.println("Ошибка преобразования из строки в число");
        }

        // Оператор throw. С помощью этого оператора мы сами можем создать исключение и вызвать его в процессе выполнения.
        try{
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            // Свое условие для ошибки. Число больше 30
            if(x>=30){
                                    // Свое сообщение об ошибке, которое мы передаем в блок catch
                throw new Exception("Число х должно быть меньше 30");
            }
        }
        //    Сюда передается наш throw
        catch(Exception ex){
                                // Сюда наше сообщение об ошибке
            System.out.println(ex.getMessage());
        }
        System.out.println("Программа завершена");
    }
}