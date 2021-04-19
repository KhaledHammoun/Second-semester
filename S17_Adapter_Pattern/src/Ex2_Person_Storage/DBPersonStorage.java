package Ex2_Person_Storage;

import java.util.ArrayList;

public class DBPersonStorage implements PersonStorage
{
    private ArrayList<Person> people;

    public DBPersonStorage()
    {
        this.people = new ArrayList<>();
    }


    @Override
    public void addPerson(Person person)
    {
        people.add(person);
    }

    @Override
    public Person getPerson(int ssn)
    {
        for (Person p : people)
        {
            if (p.getSsn() == ssn)
                return p;
        }
        return null;
    }
}
