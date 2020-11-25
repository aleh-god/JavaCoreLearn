package PaternLearn.FactoryIngrLearn;

public class Elf extends Heroes{
    Items itemSet;

    public Elf(Items itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    void born() {
        System.out.println("Рождение героя по имени: " + name);
        helmet = itemSet.putHelmet();
        armor = itemSet.putArmor();
        weapon = itemSet.putWeapon();
    }
}