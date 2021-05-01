package Ex4_Bounded_List;

public class ClientMain
{
    public static void main(String[] args)
    {
        ListADT list = new BoundedArrayList(2);

        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.contains("3"));
    }
}
