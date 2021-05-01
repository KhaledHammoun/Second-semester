package Ex3_Threadsafe_Queue;

public class ThreadSafeQueue implements StringQueue
{
    private BoundedArrayQueue queue;

    public ThreadSafeQueue(int cap)
    {
        queue = new BoundedArrayQueue(cap);
    }

    @Override
    public void enqueue(String element)
    {
        synchronized (this)
        {
            queue.enqueue(element);
        }

    }

    @Override
    public String dequeue()
    {
        synchronized (this)
        {
            return queue.dequeue();
        }
    }

    @Override
    public String first()
    {
        synchronized (this)
        {
            return queue.first();
        }
    }

    @Override
    public int size()
    {
        synchronized (this)
        {
            return queue.size();
        }
    }

    @Override
    public boolean isEmpty()
    {
        synchronized (this)
        {
            return queue.isEmpty();
        }
    }

    @Override
    public int indexOf(String element)
    {
        synchronized (this)
        {
            return queue.indexOf(element);
        }
    }

    @Override
    public boolean contains(String element)
    {
        synchronized (this)
        {
            return queue.contains(element);
        }
    }
}
