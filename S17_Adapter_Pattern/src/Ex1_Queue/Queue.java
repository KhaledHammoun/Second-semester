package Ex1_Queue;

import java.util.ArrayList;

public class Queue implements StringQueue
{
    private ArrayList<String> queue;
    private int capacity;

    public Queue(int cap)
    {
        if (cap <1)
        {
            throw new IllegalArgumentException("Can not have values less than 1 for capacity.");
        }
        queue = new ArrayList<>();
        capacity = cap;
    }

    @Override
    public void enqueue(String element)
    {
        if (element == null || element.isBlank())
        {
            throw new IllegalArgumentException("Not enough place in the queue.");
        }
        else if (!hasCapacity())
        {
            throw new IllegalStateException("Max capacity is reached.");
        }
        else
            queue.add(element);
    }

    private boolean hasCapacity()
    {
        return queue.size()< capacity;
    }

    @Override
    public String dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty.");
        }
        String toReturn = queue.get(0);
        queue.remove(toReturn);
        return toReturn;
    }

    @Override
    public String first()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The queue is empty.");
        }
        return queue.get(0);
    }

    @Override
    public int size()
    {
        return queue.size();
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public int indexOf(String element)
    {
        return queue.indexOf(element);
    }

    @Override
    public boolean contains(String element)
    {
        return queue.contains(element);
    }

    public String toString()
    {
        return queue.toString();
    }
}
