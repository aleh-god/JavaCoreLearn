package GenericLearn;

//класс, реализующий интерфейс, жестко привязан к этому типу.
class Account3<T> implements Accountable<T>{

    private T id;
    private int sum;

    Account3(T id, int sum){
        this.id = id;
        this.sum = sum;
    }

    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}
