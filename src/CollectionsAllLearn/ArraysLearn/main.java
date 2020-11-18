package CollectionsAllLearn.ArraysLearn;
import java.util.Arrays;

public class main {

    // Сложить два массива

    private int[] concatArray(int[] a, int[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int[] r = new int[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        // источник,старт чтения из источника, куда, позиция назначения, длина чтения из источника
        System.arraycopy(b, 0, r, a.length, b.length);
        // позиция назначения - так как номера ячеек начинаются с 0, то позицию назначения не надо увеличивать на единицу
        return r;
    }

    // метод для склеивания двух строковых массивов

    private static String[] concatArray(String[] a, String[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        String[] r = new String[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    // Скопировать часть массива
    private static double[] copyPartArray(double[] a, int start) {
        // start - с какой позиции нужно получить новый массив, отсчёт с 0
        if (a == null)
            return null;
        if (start > a.length)
            return null;
        double[] r = new double[a.length - start];
        System.arraycopy(a, start, r, 0, a.length - start);
        // источник,старт чтения из источника, куда, позиция назначения, длина чтения из источника
        return r;
    }

    // Задание: Метод, который переставляет две заданных ячейки местами

    private static int[] swapCellInt(int[] Arr, int a, int b) {
        int c;
        c = Arr[a];
        Arr[a] = Arr[b];
        Arr[b] = c;
        return Arr;
    }

    // Задание: Найти максимальное значение в массива

    private static int getMaxInt(int[] Arr) {
        int max = 0;
        for (int i : Arr) {
            if (max < i) max = i;
        }
        return max;
    }

    //Задача: Имеется массив, нужно переставить элементы массива в обратном порядке.

    private static int[] ArrayZercalo(int[] a) {
        if (a == null)
            return null;
        int[] r = new int[a.length];
        for (int i=0 ; i < a.length; i++) {
            r[i] = a[a.length - 1 - i];
        }
        return r;
    }

    //Задача: Имеется массив, нужно поместить нули в конец массива.

    private static int[] ArrayZeroEnd(int[] a) {
        if (a == null)
            return null;
        int[] r = new int[a.length];
        int counterZero = 0, ii = 0;

        // Копируем не нули, а нули считаем счетчиком
        for (int i=0 ; i < a.length; i++) {
            if (a[i] != 0) {
                r[ii] = a[i];
                ii++;
            } else counterZero++;
        }
        // В конец массива r дописываем необходимое колличество нулей
        for (int i=ii ; i < a.length; i++) {
            a[i] = 0;
        }
        return r;
    }

    //Задача: Имеется массив, нужно поместить нули в конец массива.

    private static int[] ArrayZeroStart(int[] a) {
        if (a == null)
            return null;
        int[] r = new int[a.length];
        int counterZero = 0;

        // нули считаем счетчиком
        for (int i : a)
            if (i == 0) counterZero++;

        // В начало массива r дописываем необходимое колличество нулей
        for (int i=0 ; i < counterZero; i++)
            r[i] = 0;

        // Копируем не нули
        int ii = counterZero;
        for (int i=0 ; i < a.length; i++) {
            if (a[i] != 0) {
                r[ii] = a[i];
                ii++;
            }
        }
        return r;
    }

    // Задание: Найти три максимальных значения в массива

    private static int[] get3MaxInt(int[] Arr) {
        if (Arr == null)
            return Arr;
        int[] max = new int[]{0, 0, 0};
        for (int i : Arr) {
            if (max[0] < i)
                if (max[1] < i)
                    if (max[2] < i) {
                        max[1] = max[2];
                        max[2] = i;
                        //System.out.println("Записываем max[2] " + max[2]);
                    }
                    else {
                        max[0] = max[1];
                        max[1] = i;
                        //System.out.println("Записываем max[1] " + max[1]);
                    }
                else {
                    max[0] = i;
                    //System.out.println("Записываем max[0] " + max[0]);
                }
        }
        return max;
    }

    public static void main(String[] agrs) {

        int[] catsNew;  // мы объявили переменную массива
        int catsAny[]; // другой вариант

        // После объявления переменной массива, можно определить сам массив с помощью ключевого слова new с указанием типа и размера.
        catsNew = new int[10];

        // Можно одновременно объявить переменную и определить массив (в основном так и делают):
        int[] cats = new int[10];
        /* Если массив создаётся таким образом, то всем элементам массива автоматически присваиваются значения по умолчанию.
         Например, для числовых значений начальное значение будет 0.
         Для массива типа boolean начальное значение будет равно false, для массива типа char - '\u0000', для массива типа класса (объекты) - null.
         */
        String[] catNames = new String[10]; // объекты - null.
        for (int i = 0; i < 10; i++)
            catNames[i] = ""; // Зануляем массив

        int[] catsInstall = {2, 5, 7, 8, 3, 0};  // В этом случае ключевое слово new не используется:

        int[] mice = { 4, 8, 10, 12, 16 };
        int result = 0;

        for (int i = 0; i < mice.length; i++) { // Оно позволяет получить количество элементов в массиве. Данное свойство удобно тем, что вы не ошибётесь с размером массива.
            result = result + mice[i];
        }
        result = result / mice.length; // общий результат делим на число элементов в массиве
        System.out.println("Среднее арифметическое: " + result);

        System.out.println("\nПрисвоение массивов");
        // Присвоение массивов - это присвоение ссылки на объект в памяти
        int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = anyNumbers;
        luckyNumbers[2] = 25;
        System.out.println("anyNumbers: " + anyNumbers[2]
                + "\nluckyNumbers: " + luckyNumbers[2]);

        // Если же вам реально нужна копия массива, то используйте метод Arrays.copyOf()
        int[] numbersCopy = Arrays.copyOf(anyNumbers, anyNumbers.length);
        System.out.println(Arrays.toString(numbersCopy));

        cats = new int[6];
        cats[5] = 7;
        String[] catsNames = {
                "Васька",
                "Кузя",
                "Барсик",
                "Мурзик",
                "Леопольд",
                "Бегемот",
                "Рыжик",
                "Матроскин"
        };
        String resultS = catsNames[3];
        System.out.println(Arrays.toString(catsNames) + "\nГлавный кот: " + resultS);

        System.out.println("\nПеребор значений массива");

        int aNums[] = { 2, 4, 6 };

        for (int i = 0; i < aNums.length; i++) {
            String strToPrint = "aNums[" + i + "]=" + aNums[i];
            System.out.println(strToPrint);
        }

        //Также есть укороченный вариант записи
        //Используется только для обычного перебора элементов.
        for (int num : aNums) {
            //num поле, которому присвоят по очереди все значения массива
            // в этом случае мы не имеем доступа к индексу массива, что не всегда подходит для задач.
            System.out.println(" Cell: " + num);
        }

        System.out.println("\nМногомерные массивы");
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        //Также массив может создаваться ключевым словом new:
        // трехмерный массив фиксированной длины
        int[][][] b = new int[2][4][4];

        int[][] twoD = new int[3][4]; // объявили двухмерный массив
        int i, j, k = 0;

        for (i = 0; i < 3; i++)
            for (j = 0; j < 4; j++) {
                twoD[i][j] = k;
                k++;
            }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++)
                System.out.print(twoD[i][j] + " ");
                System.out.print("\n");
        }


        int[][] aa = {
                {1, 2, 3},
                {4, 5},
                {6},
                {7, 8, 9,},
        };
        System.out.println(Arrays.deepToString(aa));

        System.out.println("\nРазмер многомерных массивов:");
        // Длина массива определяется по его первой размерности, то есть вычисляется количество рядов.
        System.out.println("Длинна массива это количество рядов: " + aa.length);
        // А если мы хотим узнать количество столбцов в ряду? Тогда указываете ряд, а затем вычисляете у него количество столбцов.
        System.out.println("Число колонок у третьего ряда: " + aa[2].length);
        // Не забывайте, что в массивах ряды могут содержать разное количество столбцов.

        System.out.println("\nСложить два массива");

        System.out.println("\nМетод для склеивания двух строковых массивов");
        String[] week1 = new String[] { "Понедельник", "Вторник", "Среда" };
        String[] week2 = new String[] { "Четверг", "Котопятница", "Субкота", "Воскресенье" };

        String[] week = concatArray(week1, week2);
        System.out.println(Arrays.toString(week));

        int[] arraySource1 = {10, 2, 3};
        int[] arraySource2 = {4, 5, 6};
        int[] arrayDestination = {0, 0, 0, 0, 0, 0};

        System.out.println("arraySource1: " + Arrays.toString(arraySource1));
        System.out.println("arraySource1.length= " + arraySource1.length);
        System.out.println("arraySource2: " + Arrays.toString(arraySource2));
        System.out.println("arraySource2.length= " + arraySource2.length);

        System.arraycopy(arraySource1, 0, arrayDestination, 0, 3);
        System.arraycopy(arraySource2, 0, arrayDestination, 3, 3);

        System.out.println("\narrayDestination after arrayCopy: " + Arrays.toString(arrayDestination));
        System.out.println("\nSwap 2 and 3 cells: " + Arrays.toString(swapCellInt(arrayDestination, 2,3)));
        System.out.println("\nМаксимальное значение в массиве: " + getMaxInt(arrayDestination));
        System.out.println("\n3 максимальных значений в массиве: " + Arrays.toString(get3MaxInt(arrayDestination)));

        System.out.println("\nВзять часть массива");
        double[] digits = new double[] {6.5, 3.1, 5.72};
        double[] part = copyPartArray(digits, 1);
        System.out.println(Arrays.toString(part));

        //        Задача: Имеется массив, нужно переставить элементы массива в обратном порядке.
        int[] zercalo = new int[] { 4, 9, 3, 22, 5, 18, 25, 7, 11, 15, 5, 19 };
        System.out.println("\nнужно переставить элементы массива в обратном порядке: " + Arrays.toString(zercalo));
        System.out.println("Нужно переставить элементы массива в обратном порядке: " + Arrays.toString(ArrayZercalo(zercalo)));

        //Поместить нули в конец массива
        int[] nullArr = new int[] { 5, 4, 3, 0, 6, 0, 0, 5, 6, 0, 25, 0, 8, 7, 3, 0, 1, 1, 0, 6, 4, };
        System.out.println("\nПереместить все нули в конец массива: " + Arrays.toString((nullArr)));
        System.out.println("Переместить все нули в конец массива: " + Arrays.toString(ArrayZeroEnd(nullArr)));

        // Поместить нули в начало массива
        nullArr = new int[]{5, 4, 3, 0, 6, 0, 0, 5, 6, 0, 25, 0, 8, 7, 3, 0, 1, 1, 0, 6, 4,};
        System.out.println("\nПереместить все нули в начало массива: " + Arrays.toString(nullArr));
        System.out.println("Переместить все нули в начало массива: " + Arrays.toString(ArrayZeroStart(nullArr)));
    }
}
