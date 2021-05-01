package Ex2_Sea_Bear;

public class ClientMain
{
    public static void main(String[] args)
    {
        VisitSeaBear visitSeaBear = new SeaBearGuard();

        visitSeaBear.feed(PersonType.ZOO_KEEPER);
        visitSeaBear.view(PersonType.OTHER);
        visitSeaBear.pet(PersonType.CHILD);
    }


}
