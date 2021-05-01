package Ex4_Bounded_List;

import java.util.ArrayList;

public class MyArrayList implements ListADT
{
    private ArrayList<String> list;

    public MyArrayList()
    {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(String s)
    {
        list.add(s);
    }

    @Override
    public void add(int idx, String s)
    {
        list.add(idx, s);
    }

    @Override
    public void set(int idx, String s)
    {
        list.set(idx, s);
    }

    @Override
    public String get(int idx)
    {
        return list.get(idx);
    }

    @Override
    public String remove(int idx)
    {
        return list.remove(idx);
    }

    @Override
    public boolean remove(String s)
    {
        return list.remove(s);
    }

    @Override
    public int indexOf(String s)
    {
        return list.indexOf(s);
    }

    @Override
    public boolean contains(String s)
    {
        return list.contains(s);
    }

    @Override
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    @Override
    public int size()
    {
        return list.size();
    }
}
