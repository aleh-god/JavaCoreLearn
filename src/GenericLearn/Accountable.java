package GenericLearn;

//Интерфейсы, как и классы, также могут быть обобщенными.
interface Accountable<T>{
    T getId();
    int getSum();
    void setSum(int sum);
}
