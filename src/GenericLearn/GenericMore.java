package GenericLearn;

//В данном случае тип String будет передаваться на место параметра T, а тип Double - на место параметра S.
public class GenericMore{

    public static void main(String[] args) {

        Account4<String, Double> acc1 = new Account4<String, Double>("354", 5000.87);
        String id = acc1.getId();
        Double sum = acc1.getSum();
        System.out.printf("Id: %s  Sum: %f \n", id, sum);
    }
}
class Account4<T, S>{

    private T id;
    private S sum;

    Account4(T id, S sum){
        this.id = id;
        this.sum = sum;
    }

    public T getId() { return id; }
    public S getSum() { return sum; }
    public void setSum(S sum) { this.sum = sum; }
}
