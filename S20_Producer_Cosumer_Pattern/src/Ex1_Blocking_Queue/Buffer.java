package Ex1_Blocking_Queue;

public interface Buffer<T>
{
    void put(T element);
    T take();
    T look();
    boolean isEmpty();
    boolean isFull();
    int size();
}
