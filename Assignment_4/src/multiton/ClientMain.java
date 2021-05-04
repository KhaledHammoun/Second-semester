package multiton;

public class ClientMain
{
    public static void main(String[] args)
    {
        MinedValuable test = Valuable.getValuable();
        MinedValuable test2 = Valuable.getValuable();
        MinedValuable test3 = Valuable.getValuable();
        MinedValuable test4 = Valuable.getValuable();
        MinedValuable test5 = Valuable.getValuable();

        System.out.println(test.getValue());
        System.out.println(test2.getValue());
        System.out.println(test3.getValue());
        System.out.println(test4.getValue());
        System.out.println(test5.getValue());
    }
}
