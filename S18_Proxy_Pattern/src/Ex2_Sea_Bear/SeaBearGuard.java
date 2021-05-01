package Ex2_Sea_Bear;

public class SeaBearGuard implements VisitSeaBear
{
    private InteractWithSeaBear visit;

    public SeaBearGuard()
    {
        this.visit = new InteractWithSeaBear();
    }

    @Override
    public void view(PersonType personType)
    {
        visit.view(personType);
    }

    @Override
    public void feed(PersonType personType)
    {
        if (validateFeed(personType))
        {
            visit.feed(personType);
        }
        else
            throw new IllegalArgumentException("Access denied.");
    }

    @Override
    public void pet(PersonType personType)
    {
        if (validatePet(personType))
        {
            visit.pet(personType);
        }
        else
            throw new IllegalArgumentException("Access denied.");
    }

    private boolean validateFeed(PersonType personType)
    {
        return personType.equals(PersonType.ZOO_KEEPER);
    }

    private boolean validatePet(PersonType personType)
    {
        return personType.equals(PersonType.CHILD);
    }
}
