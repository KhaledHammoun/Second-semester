package Ex2_Sea_Bear;

public class InteractWithSeaBear implements VisitSeaBear
{

    @Override
    public void view(PersonType personType)
    {
        System.out.println("Sea bear swimming around while everyone are watching.");
    }

    @Override
    public void feed(PersonType personType)
    {
        System.out.println("Sea bear chewing while the " + personType + " is feeding it.");
    }

    @Override
    public void pet(PersonType personType)
    {
        System.out.println("Sea bear poring while a " + personType + " is petting it.");
    }
}
