package Ex4_Bounded_List;

public class BoundedArrayList implements ListADT
{
    private MyArrayList boundedList;
    private int capacity;

    public BoundedArrayList(int cap)
    {
        boundedList = new MyArrayList();
        capacity = cap;
    }


    @Override
    public void add(String s)
    {
        if (validate())
            boundedList.add(s);
    }

    @Override
    public void add(int idx, String s)
    {
        if (validate())
            boundedList.add(idx, s);
    }

    @Override
    public void set(int idx, String s)
    {
            boundedList.set(idx, s);
    }

    @Override
    public String get(int idx)
    {
        return boundedList.get(idx);
    }

    @Override
    public String remove(int idx)
    {
        return boundedList.remove(idx);
    }

    @Override
    public boolean remove(String s)
    {
        return boundedList.remove(s);
    }

    @Override
    public int indexOf(String s)
    {
        return boundedList.indexOf(s);
    }

    @Override
    public boolean contains(String s)
    {
        return boundedList.contains(s);
    }

    @Override
    public boolean isEmpty()
    {
        return boundedList.isEmpty();
    }

    @Override
    public int size()
    {
        return boundedList.size();
    }

    private boolean validate()
    {
        return boundedList.size() < capacity;
    }
}
