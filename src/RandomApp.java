import java.util.Random;

public class RandomApp {
    public static void main(String[] agrs) {
        //Генерация в определённом интервале
        int min = 100;
        int max = 200;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        System.out.println("Генерация в интервале от: " + min + " до: " + max + " резульат: " + i);

        System.out.println("Случайные числа от 1 до 6 при бросании игрального кубика: " + (random.nextInt(6) + 1));

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static int getMathRandom(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int) (Math.random() * ((max - min) + 1))+min;
    }

    private static int getRandom8Java(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }
}
