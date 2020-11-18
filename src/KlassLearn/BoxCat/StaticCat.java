package Home.GOD;

// Использование static переменных и методов
public class StaticCat {
    private String mName;
    private int mAge;
    static int sId = 0;
    static int sTestNumber = 8;

    public StaticCat(String name, int age) {
        mName = name;
        mAge = age;
        sId++;
    }

    @Override
    public String toString() {
        return this.mName;
    }
}
