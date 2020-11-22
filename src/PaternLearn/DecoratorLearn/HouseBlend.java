package PaternLearn.DecoratorLearn;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
