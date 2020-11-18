package Java;

public class LogicBooleanLearn {
    public static void main(String[] agrs) {
        int a = 10 , b =4;
        boolean c = a == b;         // false
        System.out.println("Результат сравнения:" + c);
        c = a == 10;       // true
        System.out.println("Результат сравнения:" + c);
        c = a != b;         // true
        System.out.println("Результат сравнения:" + c);
        c = a != 10;       // false
        System.out.println("Результат сравнения:" + c);
        c = a < b;
        System.out.println("Результат сравнения:" + c);
        c = 10 >= 10;
        System.out.println("Результат сравнения:" + c);
        c = 10 <= 4;
        System.out.println("Результат сравнения:" + c);

        /*
|
c=a|b; (c равно true, если либо a, либо b (либо и a, и b) равны true, иначе c будет равно false)

&
c=a&b; (c равно true, если и a, и b равны true, иначе c будет равно false)

!
c=!b; (c равно true, если b равно false, иначе c будет равно false)

^
c=a^b; (c равно true, если либо a, либо b (но не одновременно) равны true, иначе c будет равно false)

||
c=a||b; (c равно true, если либо a, либо b (либо и a, и b) равны true, иначе c будет равно false)

&&
c=a&&b; (c равно true, если и a, и b равны true, иначе c будет равно false)
         */

        boolean a1 = (5 > 6) || (4 < 6); // 5 > 6 - false, 4 < 6 - true, поэтому возвращается true
        boolean a2 = (5 > 6) || (4 > 6); // 5 > 6 - false, 4 > 6 - false, поэтому возвращается false
        boolean a3 = (5 > 6) && (4 < 6); // 5 > 6 - false, поэтому возвращается false (4 < 6 - true, но не вычисляется)
        boolean a4 = (50 > 6) && (4 / 2 < 3); // 50 > 6 - true, 4/2 < 3 - true, поэтому возвращается true
        boolean a5 = (5 > 6) ^ (4 < 6); // 5 > 6 - true, поэтому возвращается true (4 < 6 - false)
        boolean a6 = (50 > 6) ^ (4 / 2 < 3); // 50 > 6 - true, 4/2 < 3 - true, поэтому возвращается false
        int i = 49, j = 5;
        boolean a7;
        System.out.println("i = " + i + " j = " + j);
        a7 = (i == 0);
        System.out.println("i = 0 " + a7);
        a7 = (i == 49 );
        System.out.println("i = 49 " + a7);
        a7 = (j == 0);
        System.out.println("j = 0 " + a7);
        a7 = (j == 49);
        System.out.println("i = 49 " + a7);
        a7 = ( (i == 0) | (i == 49 ) );
        System.out.println("(i = 0) | (i = 49 ) " + a7);


        a7 = ( ((i != 0) | (i != 49 )) | ((j != 0) | (j != 49)) );
        System.out.println("(i != 0) | (i != 49 ) | ( (j != 0) | (j != 49) ) " + a7);

    }
}
