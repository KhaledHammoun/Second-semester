package deposit;

import multiton.MinedValuable;

public interface Deposit
{
    void put(MinedValuable item);
    MinedValuable take();
    boolean isEmpty();
    boolean isFull();
    int size();
}
