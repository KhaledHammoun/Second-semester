package Ex1_Blocking_Queue;

public class BlockingQueue<T> implements Buffer<T>
{
    private QueueADT<T> buffer;

    public BlockingQueue(int capacity)
    {
        buffer = new BoundedArrayQueue<>(capacity);
    }

    @Override
    public synchronized void put(T element)
    {
        if (element == null)
        {
            throw new IllegalArgumentException("Cannot add null element to the buffer.");
        }
        while (isFull())
        {
            try
            {
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " am waiting to put an element to the buffer. Size: " + size());
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        buffer.enqueue(element);
        System.out.println(Thread.currentThread().getName() + " just set an element in the buffer. Size: " + size());

        notifyAll();
    }

    @Override
    public synchronized T take()
    {
        while (isEmpty())
        {
            notifyAll();
            try
            {
                System.out.println(Thread.currentThread().getName() + " am waiting to take an element from the buffer. Size: " + size());
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " just took an element from the buffer. Size: " + size());
        return buffer.dequeue();
    }

    @Override
    public synchronized T look()
    {
        if (isEmpty())
            return null;
        return buffer.first();
    }

    @Override
    public synchronized boolean isEmpty()
    {
        return buffer.isEmpty();
    }

    @Override
    public synchronized boolean isFull()
    {
        return buffer.isFull();
    }

    @Override
    public synchronized int size()
    {
        return buffer.size();
    }

    @Override
    public synchronized String toString()
    {
        return "buffer= " + buffer;
    }
}
